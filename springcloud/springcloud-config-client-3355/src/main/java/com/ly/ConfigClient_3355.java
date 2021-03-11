package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * liyang 2021-03-11
 *
 * 这个启动类没有端口号，因为会去从 config-server 去拿指定环境（dev）的配置，dev的端口号为 8201
 * http://localhost:8201/config
 */
@SpringBootApplication
public class ConfigClient_3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355.class, args);
    }

}
