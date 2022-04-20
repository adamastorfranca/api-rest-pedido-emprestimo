package br.com.uniesp.pedido.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.uniesp.pedido.model.entity.Pedido;

public interface PedidoRespository extends CrudRepository<Pedido, Long> {

	@Query("SELECT p FROM Pedido p WHERE "
			+ "p.status = 'BLOQUEADO' AND "
			+ "p.interessado.nome = :nome")
	List<Pedido> buscaPorEmprestimosBloqueadosDoSolicitante(String nome);
	
}
