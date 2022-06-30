package br.edu.univas.gabriel.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class HotelDto {
	@NotNull(message = "O Número do quarto não pode ser null.")
	private int numeroQuarto;
	
	
	@NotNull(message = "A classe não pode ser null.")
	@NotEmpty(message = "A classe não pode ser vazia.")
	private String classe;
	
	
	@NotNull(message = "A descrição não pode ser null.")
	@NotEmpty(message = "A descrição não pode ser vazia.")
	private String descricao;
	
	
	@NotNull(message = "O valor da diária não pode ser null.")
	private double valorDiaria;
	
	
	@NotNull(message = "A data de manutenção não pode ser null.")
	@NotEmpty(message = "A data manutençao não pode ser vazia.")
	private String dataManutencao;


	public HotelDto() {
	}

	public HotelDto(int numeroQuarto, String classe, String descricao, double valorDiaria, String dataManutencao) {
		this.numeroQuarto = numeroQuarto;
		this.classe = classe;
		this.descricao = descricao;
		this.valorDiaria = valorDiaria;
		this.dataManutencao = dataManutencao;
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


	public String getDataManutencao() {
		return dataManutencao;
	}


	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
}
