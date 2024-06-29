package br.com.example.picpay_chanllenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EasyTreansferApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyTreansferApplication.class, args);
    }

}
