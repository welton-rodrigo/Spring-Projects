package io.github.welton.service;


import io.github.welton.domain.entity.Pedido;
import io.github.welton.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);
}
