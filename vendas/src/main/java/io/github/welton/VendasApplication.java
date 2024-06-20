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
           clientes.salvar(new Cliente("Raquel"));
           clientes.salvar(new Cliente("Welton"));
            clientes.salvar(new Cliente("gabriel"));

           List<Cliente> todosClientes =  clientes.obterTodos();
           todosClientes.forEach(System.out::println);

          todosClientes.forEach(c ->{
              c.setNome(c.getNome() + "atualizado.");
          });


        };
    }

    //psvm atalho para criar methodo main
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
