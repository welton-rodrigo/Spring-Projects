package io.github.welton;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Development
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executarteste(){
        return args -> {
        System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }

}
