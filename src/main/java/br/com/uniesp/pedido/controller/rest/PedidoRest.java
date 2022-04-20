package br.com.uniesp.pedido.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniesp.pedido.model.entity.Pedido;
import br.com.uniesp.pedido.model.form.PedidoAtualizarForm;
import br.com.uniesp.pedido.model.form.UsuarioServidorCadastroForm;
import br.com.uniesp.pedido.model.service.PedidoService;

@RestController
@RequestMapping(name = "/rest/pedidos")
public class PedidoRest {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping(value = "/cadastrar")
	public @ResponseBody ResponseEntity<Pedido> cadastrarPedido(@RequestBody UsuarioServidorCadastroForm form){
		Pedido pedido = pedidoService.salvar(form);
		
		if (pedido == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pedido, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	public @ResponseBody ResponseEntity<Pedido> atualizarPedido(@RequestBody PedidoAtualizarForm form){
		Pedido pedido = pedidoService.atualizar(form);
		
		if (pedido == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pedido, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPorEmprestimosBloqueadosDoSolicitante/{nome}")
	public @ResponseBody ResponseEntity<List<Pedido>> buscarPorEmprestimosBloqueadosDoSolicitante(@PathVariable String nome){
		List<Pedido> pedidos = pedidoService.buscarPorEmprestimosBloqueadosDoSolicitante(nome);
		
		if (pedidos == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pedidos, HttpStatus.OK);
	}
}
