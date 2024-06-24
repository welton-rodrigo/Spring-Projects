package io.github.welton;

import io.github.welton.domain.entity.Cliente;
import io.github.welton.domain.entity.Pedido;
import io.github.welton.domain.repository.Clientes;
import io.github.welton.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication

public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ){
        return args -> {
            System.out.println("Salvando Clientes");
            Cliente fulano = new Cliente("Fulano1");
            clientes.save(fulano);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100.00));

            pedidos.save(p);

           Cliente cliente =  clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());



        };
    }

    //psvm atalho para criar methodo main
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
