package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * liyang 2021-03-11
 *
 * 获取方式：（ main 可以省略，因为配置中制定了默认分支）
 * http://localhost:3344/main/application-test.yml
 * http://localhost:3344/application-dev.yml
 * http://localhost:3344/application/dev/main
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer_3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3344.class, args);
    }

}
