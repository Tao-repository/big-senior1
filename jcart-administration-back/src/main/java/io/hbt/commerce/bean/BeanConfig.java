package io.hbt.commerce.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.security.SecureRandom;

@Configuration
public class BeanConfig {

    @Bean
    public SecureRandom getSecureRandom(){
        return new SecureRandom();
    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        return new JavaMailSenderImpl();
    }

}
