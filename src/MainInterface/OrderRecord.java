
package MainInterface;

import java.text.DateFormat;

public class OrderRecord {
	
	String name;
	double price;
	double total;
	String customerId;
	String date_time;
	int Index;
	
	
	
	
	public void setDateTime()
	{
		TimeManagement time = new TimeManagement();
		date_time = time.getCurrentTime();
	}
	
	public String getDateTime() 
	{
		return date_time;
	}
		
	
	
	public  OrderRecord() {
		
		name = " ";
		price  =0.0;
		
	}

	public  OrderRecord(String name , double price) {
		this.name= name;
		this.price= price;
	}

	
	public OrderRecord(double total) {
		this.total=total;
	}






	public double getTotal() {
		
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		
		return "name :" +name + " price :" +price + " Total " +(total+price);
	}

	public String toString1() {	
		return "Total " + total ;
	}

}
