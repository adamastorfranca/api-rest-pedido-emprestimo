package br.com.uniesp.pedido.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniesp.pedido.model.entity.UsuarioServidor;
import br.com.uniesp.pedido.model.form.UsuarioServidorCadastroForm;
import br.com.uniesp.pedido.model.repository.UsuarioServidorRespository;

@Service
public class UsuarioServidorService {
	
	@Autowired
	private UsuarioServidorRespository usuarioServidorRespository;
	
	public UsuarioServidor salvar(UsuarioServidorCadastroForm form) {
		UsuarioServidor servidor = form.criarUsuarioServidor();
		usuarioServidorRespository.save(servidor);
		return servidor;
	}
	
	public UsuarioServidor buscarPorNome(String nome) {
		Optional<UsuarioServidor> optional = usuarioServidorRespository.findByNome(nome);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
