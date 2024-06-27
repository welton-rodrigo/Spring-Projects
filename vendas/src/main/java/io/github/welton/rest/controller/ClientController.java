package io.github.welton.rest.controller;

import io.github.welton.domain.entity.Cliente;
import io.github.welton.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClientController {

    private Clientes clientes;

    public ClientController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
       Optional<Cliente> c = clientes.findById(id);

        if (c.isPresent()) {
            return ResponseEntity.ok(c.get());
        }
        return null;
    }


}


/*
ANOTAÇÕES.
@ResponseBody -> Retorna uma resposta no corpo da requisição no formato JSON, se não for colocado dara erro, a menos que o retorno seje = string
Optional -> pode ou nao existir por isso retorna um optional
* */
