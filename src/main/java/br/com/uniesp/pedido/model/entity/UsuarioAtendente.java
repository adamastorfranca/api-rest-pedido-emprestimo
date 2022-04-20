package br.com.uniesp.pedido.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "atendentes")
@Data
public class UsuarioAtendente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	
	public UsuarioAtendente() {}
	
	public UsuarioAtendente(String nome) {
		this.nome = nome;
	}
}
