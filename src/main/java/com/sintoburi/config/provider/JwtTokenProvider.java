package com.sintoburi.config.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import sun.java2d.loops.FillRect;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.List;

/**
 * @author seongnamfc
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
        return null;
    }

    // Jwt 토큰 인증 정보 조회
    public Authentication getAuthentication(String token) {
        return null;
    }



}
