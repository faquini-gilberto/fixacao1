package entidades;

public class ProductF2 {
	
	private String name;
	private Double price;
	
	public ProductF2() {
	}

	public ProductF2(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String priceTag() {
		return name + " $ " + String.format("%.2f", price);
	}
}
