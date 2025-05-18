package dev.avee.bettersecurity.common.properties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;
    private int accessTokenTtlInMinutes;
}
