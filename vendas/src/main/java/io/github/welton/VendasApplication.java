package io.github.welton;

import io.github.welton.domain.entity.Cliente;
import io.github.welton.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication

public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Raquel"));
            clientes.save(new Cliente("Welton"));
            clientes.save(new Cliente("Gabriel"));


            boolean existe = clientes.existsByNome("Welton");
            System.out.println("Existe um Cliente com nome Welton?" + existe);

            System.out.println("Pesquisando por Welton no Banco?");
            List<Cliente> lista =  clientes.encontrarPorNome("Welton");
            lista.forEach(System.out::println);

           System.out.println("deletando por nome");
           clientes.deleteByNome("Welton");

            System.out.println("listar todos");
            clientes.findAll();
            List<Cliente> lista2 = clientes.findAll();
            lista2.forEach(System.out::println);
        };
    }

    //psvm atalho para criar methodo main
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
