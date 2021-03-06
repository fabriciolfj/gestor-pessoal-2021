package br.com.macgarcia.gestorpessoal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RENDA")
public class Renda extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Decrição da renda é obrigatório")
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@NotNull(message = "Valor da renda é obrigatório")
	@Positive(message = "Valor informado é inválido")
	@Column(name = "VALOR")
	private Double valor;
	
	@NotNull(message = "Data da renda é obrigatória")
	@Column(name = "DATA_RENDA")
	private LocalDate dataRenda;
	
	@JsonIgnore	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	@Deprecated
	public Renda() {}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataRenda() {
		return dataRenda;
	}

	public void setDataRenda(LocalDate dataRenda) {
		this.dataRenda = dataRenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
