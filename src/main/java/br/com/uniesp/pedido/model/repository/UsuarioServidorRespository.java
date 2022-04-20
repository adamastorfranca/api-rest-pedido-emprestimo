package br.com.uniesp.pedido.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.uniesp.pedido.model.entity.UsuarioServidor;

public interface UsuarioServidorRespository extends CrudRepository<UsuarioServidor, Long> {
	
	Optional<UsuarioServidor> findByNome(String nome);

}
