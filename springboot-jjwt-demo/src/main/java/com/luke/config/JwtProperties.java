package com.luke.config;

import com.luke.utils.RsaUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@Getter
@Setter
@Log4j2
@Configuration
public class JwtProperties {

    /**
     * 密钥
     */
    @Value("${config.jwt.secret}")
    private String secret;

    /**
     * 公钥地址
     */
    @Value("${config.jwt.publicKeyPath}")
    private String publicKeyPath;

    /**
     * 私钥地址
     */
    @Value("${config.jwt.privateKeyPath}")
    private String privateKeyPath;

    /**
     * token过期时间
     */
    @Value("${config.jwt.expire}")
    private int expire;

    /**
     * cookie名字
     */
    @Value("${config.jwt.cookieName}")
    private String cookieName;


    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 私钥
     */
    private PrivateKey privateKey;


    /**
     * 在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init(){
        try {
            File pubKey = new File(publicKeyPath);
            File priKey = new File(privateKeyPath);
            if (!pubKey.exists() || !priKey.exists()) {
                //生成公钥和私钥
                RsaUtils.generateKey(publicKeyPath, privateKeyPath, secret);
            }
            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(publicKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(privateKeyPath);
        } catch (Exception e) {
            log.error("初始化公钥和私钥失败！", e);
            throw new RuntimeException();
        }
    }
}
