package io.github.welton.rest.controller;

import io.github.welton.domain.entity.Cliente;
import io.github.welton.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    private Clientes clientes;

    public ClientController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
     public Cliente getClienteById(@PathVariable Integer id) {
       return clientes.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO"));

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
     public Cliente save(@RequestBody Cliente cliente){
        return clientes.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientes.findById(id)
                .map( cliente -> {
                    clientes.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente cliente){

          clientes
                    .findById(id)
                    .map( clienteExistente -> {
                        cliente.setId(clienteExistente.getId());
                        clientes.save(cliente);
                        return clienteExistente;
                    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO"));
    }

    @GetMapping
    public List<Cliente> find(Cliente cliente){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(cliente, matcher);
        return clientes.findAll(example);


    }

}


/*
ANOTAÇÕES.
@ResponseBody -> Retorna uma resposta no corpo da requisição no formato JSON, se não for colocado dara erro, a menos que o retorno seje = string
Optional -> pode ou nao existir por isso retorna um optional
@RequestBody os dados que vem da requisição
@putMapping - > para atualizar integralmente
Example

* */
