package br.com.uniesp.pedido.model.form;

import br.com.uniesp.pedido.model.entity.UsuarioServidor;
import lombok.Data;

@Data
public class UsuarioServidorCadastroForm {
	
	private String nome;
	
	public UsuarioServidor criarUsuarioServidor() {
		return new UsuarioServidor(nome);
	}

}
