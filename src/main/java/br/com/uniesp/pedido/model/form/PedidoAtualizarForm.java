package br.com.uniesp.pedido.model.form;

import br.com.uniesp.pedido.model.entity.StatusPedido;
import lombok.Data;

@Data
public class PedidoAtualizarForm {
	
	private Long id;
	private String nomeAtendente;
	private StatusPedido status;
	
}
