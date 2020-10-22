package com.galaxyware.colaborae.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UsuarioAPIModel implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_usuario;

	private String nome;

	private String cpf;

	private String telefone;

	private String email;

	private String descricao;


}
