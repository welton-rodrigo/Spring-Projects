package io.github.welton.service;


import io.github.welton.domain.entity.Pedido;
import io.github.welton.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
}
