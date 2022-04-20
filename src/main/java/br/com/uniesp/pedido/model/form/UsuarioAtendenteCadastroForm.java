package br.com.uniesp.pedido.model.form;

import br.com.uniesp.pedido.model.entity.UsuarioAtendente;

public class UsuarioAtendenteCadastroForm {
	
	private String nome;
	
	public UsuarioAtendente criarUsuarioAtendente() {
		return new UsuarioAtendente(nome);
	}

}
