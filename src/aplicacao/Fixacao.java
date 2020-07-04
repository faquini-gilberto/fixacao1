package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Client;
import entidades.Order;
import entidades.OrderItem;
import entidades.Product;
import entidades_enum.OrderStatus;

public class Fixacao {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		//SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf1.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		//System.out.println(client.getName() + client.getBirthDate());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		//System.out.println(order.getMoment() + " " + order.getStatus());
		System.out.print("How many items to this order? ");
		int num = sc.nextInt();
		//System.out.println();
		for (int i=0; i<num; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product Name: ");
			String prodName = sc.next();
			System.out.print("Product Price: ");
			Double prodPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int prodQty = sc.nextInt();
			Product product = new Product(prodName, prodPrice);
			OrderItem orderItem = new OrderItem(prodQty, prodPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		
		sc.close();
	}

}
