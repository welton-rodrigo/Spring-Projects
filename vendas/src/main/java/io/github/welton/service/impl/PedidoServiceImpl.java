package io.github.welton.service.impl;

import io.github.welton.domain.repository.Pedidos;
import io.github.welton.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
