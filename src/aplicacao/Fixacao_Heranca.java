package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.ImportedProduct;
import entidades.ProductF2;
import entidades.UsedProduct;

public class Fixacao_Heranca {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<ProductF2> lista = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			
		
			System.out.print("Common, used or imported (c/u/i): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				//ProductF2 prod = new ImportedProduct(name, price, customsFee);
				lista.add(new ImportedProduct(name, price, customsFee));
			}
			else {
				if (ch == 'u') {
					System.out.print("Manufacture Date: ");
					Date manufactureDate = sdf.parse(sc.next());
					lista.add(new UsedProduct(name, price, manufactureDate));
				}
				else {
					lista.add(new ProductF2(name, price));
				}
			}
		}	
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (ProductF2 prod :  lista) {
			System.out.println(prod.priceTag());
		}
			
		
		
		sc.close();
	}

}
