package io.github.welton.service;
import io.github.welton.model.Cliente;
import io.github.welton.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    @Autowired
    public ClientesService (ClientesRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);


    }

    public void validarCliente(Cliente cliente){
        //aplica validacoes
    }
}



//Service é aonde acontece todas minhas regras de negocio