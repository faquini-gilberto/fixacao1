package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends ProductF2 {
	
	public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufactureDate;

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}
	
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " (used) $ ");
		sb.append(String.format("%.2f",getPrice()) + " (Manufacture date: ");
		sb.append(sdf.format(manufactureDate));
		sb.append(")");
		return sb.toString();
	}
	
	
}
