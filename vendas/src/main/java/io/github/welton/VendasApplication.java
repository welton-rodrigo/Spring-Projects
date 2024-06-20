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
            clientes.save(new Cliente("gabriel"));

           List<Cliente> todosClientes =  clientes.findAll();
           todosClientes.forEach(System.out::println);

           System.out.println("Buscando Clientes por nome");
           clientes.findByNomeLike("Welton").forEach(System.out::println);

         System.out.println("Deletando todos por nome");
           clientes.findByNomeLike("A%Welton%X").forEach(c -> {
                clientes.delete(c);
           });

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c ->{
              c.setNome(c.getNome() + "atualizado.");
             clientes.save(c);
          });

            todosClientes = clientes.findAll();

           if(todosClientes.isEmpty()){
                System.out.println("Nenhum Cliente encontrado!");
            }else {
                System.out.println("Clientes encontrados!");
                todosClientes.forEach(System.out::println);
            }
        };
    }

    //psvm atalho para criar methodo main
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
