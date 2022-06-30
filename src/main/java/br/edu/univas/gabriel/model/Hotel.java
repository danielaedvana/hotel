package br.edu.univas.gabriel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@Column(name = "numero_quarto", nullable = false)
	private int numeroQuarto;
	@Column(name = "classe", length = 255,nullable = false)
	private String classe;
	@Column(name = "descricao", length = 255,nullable = false)
	private String descricao;
	@Column(name = "valor_diaria", nullable = false)
	private double valorDiaria;
	@Column(name = "data_manutencao", nullable = false)
	private long dataManutencao;
	
	public Hotel() {
	}

	public Hotel(int numeroQuarto, String classe, String descricao, double valorDiaria, long dataManutencao) {
		this.numeroQuarto = numeroQuarto;
		this.classe = classe;
		this.descricao = descricao;
		this.valorDiaria = valorDiaria;
		this.dataManutencao = dataManutencao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public long getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(long dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
	
}
