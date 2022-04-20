package br.com.uniesp.pedido.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataSolicitacao = LocalDate.now();
	
	private LocalDate dataAtendimento;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.AGUARDANDO;
	
	@OneToOne
	@JoinColumn(name = "interessado_id")
	private UsuarioServidor interessado;
	
	@OneToOne
	@JoinColumn(name = "atendente_id")
	private UsuarioAtendente atendente;

	public Pedido() {}
	
	public Pedido(UsuarioServidor interessado) {
		this.interessado = interessado;
	}
	
	public Pedido(LocalDate dataAtendimento, UsuarioServidor interessado, UsuarioAtendente atendente) {
		this.dataAtendimento = dataAtendimento;
		this.interessado = interessado;
		this.atendente = atendente;
	}
}
