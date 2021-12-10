package com.sintoburi.service.impl;

import com.sintoburi.dto.auth.JwtDto;
import com.sintoburi.service.JwtService;
import com.sintoburi.util.UtilJwtAuth;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * @author seongnamfc
 * @package com.sintoburi.service.impl
 * @file JwtServiceImpl
 * @description
 * @date 2021/11/23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Autowired
    private UtilJwtAuth utilJwtAuth;

    @Override
    public String getJwtFromRequest(HttpServletRequest request) {
        String result = null;

        // 쿠키에 있는 JWT 를 우선 조회, 없으면 Header 조회
        Cookie cookieJwt = WebUtils.getCookie(request, "jwt");
        if (cookieJwt != null) {
            result = cookieJwt.getValue();
        } else {
            String headerJwt = request.getHeader("authorization");
            if (!"".equals(headerJwt)) result = headerJwt;
        }

        return result;
    }

    @Override
    public JwtDto parsedJwt(String jwt) {

        String testToken = createToken("testToken", 100000);
        String jerrySecretKey = "jerrygaoyanglaraveljwtlaraveljwt";
        String tempSecretyKey = "secret-key";

        String[] chunks = utilJwtAuth.getJwtArray(jwt);
        String headerBase64 = chunks[0];
        String payloadBase64 = chunks[1];
        String signatureBase64 = chunks[2];

        log.info("headerBase64 : " + headerBase64);
        log.info("payloadBase64 : " + payloadBase64);
        log.info("signatureBase64 : " + signatureBase64);

        String secretKeyBase64 = utilJwtAuth.encodeBase64(jerrySecretKey);
        log.info("secret-key : " + jerrySecretKey);
        log.info("secretKeyBase64 : " + secretKeyBase64);

        String verifyString = headerBase64+"."+payloadBase64+"."+secretKeyBase64;

        String payloadDecoded = utilJwtAuth.decodeBase64(payloadBase64);
        log.info("payloadDecoded = " + payloadDecoded);

        log.info("[verifyString] : " + verifyString);

        String signatureString = utilJwtAuth.decodeBase64(signatureBase64);
        log.info("[signatureString] : " + signatureString);

        if(BCrypt.checkpw(verifyString, signatureString)) {
            JwtDto jwtDto = utilJwtAuth.decodeJwt(jwt);
            log.info("일치 합니다.");
            return jwtDto;
        } else {
            log.info("일치 하지 않습니다.");
            return null;
        }
    }

    private String createToken(String tokenName, long expTime) {
        String SECRET_KEY = "jerrygaoyanglaraveljwtlaraveljwt";
        if(expTime <= 0) {
            throw new RuntimeException("Expired time must be greater than 0");
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;	// 토큰 암호화 알고리즘

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);	// Binary Data를 Text로 바꿈
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());	// 암호화된 key

        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date exp = new Date(now+expTime);

        String jwt = Jwts.builder()
//                .setHeaderParam("type", "jwt")
                .setId(UUID.randomUUID().toString())	// jti
                .setIssuedAt(issuedAt)	// 토큰 발행 시간
                .setNotBefore(issuedAt)	// 지정된 시간 이전에는 토큰을 처리하지 않아야 함을 의미
                .signWith(signingKey, signatureAlgorithm)	// 토큰 암호화 알고리즘
                .setExpiration((exp))		// 토큰 만료시간
//				.setAudience("");	// audience는 토큰을 사용할 수신자인데.. 정확히 어떻게 사용 하는지 파악 필
//				.setSubject(tokenName)	// 뭔지 아직 파악 안됨
                .compact();
        return jwt;
    }



    @Override
    public Boolean checkJwtValid(String jwt, String authRole) {
        boolean result = false;

        if(result) {

            switch (authRole) {
                case "User":

                    break;
                case "Admin":

                    break;
            }
        }
        return false;
    }

    @Override
    public String refreshJwt(String jwt) {
        return null;
    }
}
