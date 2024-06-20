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
           clientes.salvar(new Cliente("Raquel"));
           clientes.salvar(new Cliente("Welton"));
            clientes.salvar(new Cliente("gabriel"));

           List<Cliente> todosClientes =  clientes.obterTodos();
           todosClientes.forEach(System.out::println);

            System.out.println("Buscando Clientes por nome");
           clientes.buscarPorNome("Welt").forEach(System.out::println);

            System.out.println("buscando cliente por nome. Cliente encontrado : ");
            clientes.buscarPorNome("Welt").forEach(System.out::println);

            System.out.println("Deletando todos por nome");
            clientes.buscarPorNome("Wel").forEach(c -> {
                clientes.deletar(c);
            });

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c ->{
              c.setNome(c.getNome() + "atualizado.");
              clientes.atualizar(c);
          });

            todosClientes = clientes.obterTodos();

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
