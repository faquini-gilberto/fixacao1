package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades_enum.Nivel;

public class Colaborador {
	private String nome;
	private Nivel nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	List<ContratoHora> contratos = new ArrayList<>();
	
	public Colaborador() {
		
	}

	public Colaborador(String nome, Nivel nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	public void adicionaContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar calend = Calendar.getInstance();
		for (ContratoHora ch : contratos) {
			calend.setTime(ch.getData());
			int ch_ano = calend.get(Calendar.YEAR);
			
			int ch_mes = calend.get(Calendar.MONTH) + 1;
			if (ch_ano == ano && ch_mes == mes) {
				soma += ch.valorTotal();
			}
		}
		return soma;
	}
}
