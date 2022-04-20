package br.com.uniesp.pedido.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniesp.pedido.model.entity.UsuarioAtendente;
import br.com.uniesp.pedido.model.repository.UsuarioAtendenteRespository;

@Service
public class UsuarioAtendenteService {
	
	@Autowired
	private UsuarioAtendenteRespository usuarioAtendenteRespository;
	
	public UsuarioAtendente salvar(String nome) {
		UsuarioAtendente atendente = new UsuarioAtendente(nome);
		usuarioAtendenteRespository.save(atendente);
		return atendente;
	}

}
