package com.sintoburi.config.provider;

import com.sintoburi.constant.JwtConst;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

/**
 * @author seongnamfc
 *
 * @package com.sintoburi.util
 * @file JwtTokenProvider
 * @description
 * @date 2021/11/13
 */
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private PrivateKey secretKey;

    // 30( 1000 * 60초 * 30분) = 30분
    private long ACCESS_TOKEN_EXP = 1000 * 60l * 30l;
    // 30일( 1000 * 60초 * 60초 * 24시간 * 30일) = 30일
    private long REFRESH_TOKEN_EXP = 1000 * 60l * 60l * 24l * 30;

    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() throws IOException, GeneralSecurityException {
//        Path path = Path.get("src/xxx");
//        List<String> reads = Files.readAlllines(path);
//        String read = "";
//        for (String str : reads) {
//            read += str+"\n";
//        }
//        secretKey = PemReader.getPrivatekeyFromString(Read);
    }


    //Jwt 토큰 생성
    public String createToken(String username, List<String> roles, PrivateKey key) {
        long now = System.currentTimeMillis();
        Date issuedAt = new Date();

        String jwt = Jwts.builder()
                .setHeaderParam("type", "JWT")
                .claim("username", username)
                .claim(JwtConst.ACCESS_TOKEN.getShortName(), "at")
                .claim(JwtConst.ACCESS_TOKEN.getShortName(), "rt")
                .setIssuedAt(issuedAt)	// 토큰 발행 시간
                .setNotBefore(issuedAt)	// 지정된 시간 이전에는 토큰을 처리하지 않아야 함을 의미
                .setExpiration(new Date(now+(ACCESS_TOKEN_EXP)))		// 토큰 만료시간
                .compact();

        return jwt;
    }

    // Jwt 토큰 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getCustomerInfo(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 회원 정보 추출 by secretKey
    public String getCustomerInfo(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    // 회원 정보 추출 by privateKey
    public String getCustomerInfo(String token, PrivateKey privateKey) {
        return Jwts.parserBuilder().setSigningKey(privateKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    // Reuqest header에서 토큰 파싱
    public String parseToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    // Jwt 유효성 및 만료일자 확인 by secretKey
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch(Exception e) {
            return false;
        }
    }

    // Jwt 유효성 및 만료일자 확인 by privateKey
    public boolean validateToken(String token, PrivateKey privateKey) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(privateKey).build().parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch(Exception e) {
            return false;
        }
    }

}
