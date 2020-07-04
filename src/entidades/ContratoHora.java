package entidades;

import java.util.Date;

public class ContratoHora {
	private Date data;
	private Double valorPorHora ;
	private Integer qtHoras;
	
	public ContratoHora() {
	}
	
	public ContratoHora(Date data, Double valorPorHora, Integer qtHoras) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.qtHoras = qtHoras;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getQtHoras() {
		return qtHoras;
	}

	public void setQtHoras(Integer qtHoras) {
		this.qtHoras = qtHoras;
	}
	
	public double valorTotal() {
		return valorPorHora * qtHoras;
	}			
}
