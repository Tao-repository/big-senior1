package io.hbt.commerce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("io.hbt.commerce.dao")
@EnableSwagger2
public class JcartStoreBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcartStoreBackApplication.class, args);
    }

}
