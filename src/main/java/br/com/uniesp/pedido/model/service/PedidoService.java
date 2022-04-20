package br.com.uniesp.pedido.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniesp.pedido.model.entity.Pedido;
import br.com.uniesp.pedido.model.entity.UsuarioAtendente;
import br.com.uniesp.pedido.model.entity.UsuarioServidor;
import br.com.uniesp.pedido.model.form.PedidoAtualizarForm;
import br.com.uniesp.pedido.model.form.UsuarioServidorCadastroForm;
import br.com.uniesp.pedido.model.repository.PedidoRespository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRespository pedidoRespository;
	@Autowired
	private UsuarioServidorService usuarioServidorService;
	@Autowired
	private UsuarioAtendenteService usuarioAtendenteService;
	
	public Pedido salvar(UsuarioServidorCadastroForm form) {
		UsuarioServidor buscarExistente = usuarioServidorService.buscarPorNome(form.getNome());
		Pedido pedido;
		if(buscarExistente != null) {
			pedido = new Pedido(buscarExistente);
			pedidoRespository.save(pedido);
			return pedido;
		}
		UsuarioServidor servidor = usuarioServidorService.salvar(form);
		pedido = new Pedido(servidor);
		pedidoRespository.save(pedido);
		return pedido;
	}
	
	public Pedido atualizar(PedidoAtualizarForm form) {
		Pedido pedidoAtualizacao;
		UsuarioAtendente atendente = usuarioAtendenteService.salvar(form.getNomeAtendente());
		Optional<Pedido> optional = pedidoRespository.findById(form.getId());
		if(optional.isPresent()) {
			pedidoAtualizacao = optional.get();
			pedidoAtualizacao.setDataAtendimento(LocalDate.now());
			pedidoAtualizacao.setAtendente(atendente);
			pedidoAtualizacao.setStatus(form.getStatus());
			pedidoRespository.save(pedidoAtualizacao);
			return pedidoAtualizacao;
		}
		return null;
	}
	
	public List<Pedido> buscarPorEmprestimosBloqueadosDoSolicitante(String nome){
		List<Pedido> pedidos = pedidoRespository.buscaPorEmprestimosBloqueadosDoSolicitante(nome);
		if(pedidos.isEmpty()) {
			return null;
		}
		return pedidos;
	}

}
