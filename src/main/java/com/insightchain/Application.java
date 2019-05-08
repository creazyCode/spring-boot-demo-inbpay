package com.insightchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
*
* @description spring boot启动类
* @time 2019/1/15 11:50
* @author tianxiang@insightchain.io
*
*/
@Controller
@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.insightchain.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
