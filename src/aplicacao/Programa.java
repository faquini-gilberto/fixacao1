package aplicacao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entidades.Colaborador;
import entidades.ContratoHora;
import entidades.Departamento;
import entidades_enum.Nivel;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre o nome do Departamento : ");
		String depName = sc.next();
		System.out.println("Entre com os Dados do Colaborador:");
		System.out.print("Nome : ");
		String colabName = sc.next();
		System.out.print("Nivel : ");
		String colabNivel = sc.next();
		System.out.print("Salario Base : ");
		Double salarBase = sc.nextDouble();
		Colaborador colab = new Colaborador(colabName, Nivel.valueOf(colabNivel), salarBase, new Departamento(depName));
		
		System.out.print("Quantos contratos para este Colaborador : ");
		int numcont = sc.nextInt();
		for (int i=0; i<numcont; i++) {
			System.out.println("Entre Dados do Contrato #" + (i + 1));
			System.out.print("Data (DD/MM/AAAA) : ");
			Date dtContrato = sdf.parse(sc.next());  // add throws
			System.out.print("Valor por Hora : ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Quantidade de Horas : ");
			Integer qtHoras = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dtContrato, valorPorHora, qtHoras);
			colab.adicionaContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Entre Mes a Ano para calcular Renda (MM/AAAA) : ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + colab.getNome());
		System.out.println("Departamento: " + colab.getDepartamento().getDepto());
		System.out.println("Renda em " + mesAno + ": " +  String.format("%.2f%n", colab.renda(ano, mes)));
		
		
		sc.close();

	}

}
