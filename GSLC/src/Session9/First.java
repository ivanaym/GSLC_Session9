package Session9;

public class First extends Ticket implements Discount{
	
	private String lounge;

	public First(String planeName, String departure, String destination, String date, String time, String flightClass,
		   String lounge) {
		super(planeName, departure, destination, date, time, flightClass);
		this.lounge = lounge;
	}
	
	// Getter Setter
	public String getLounge() {
		return lounge;
	}

	public void setLounge(String lounge) {
		this.lounge = lounge;
	}
	
	// Harga tiket berdasarkan destinasi tujuan
	@Override
	public int generatePrice() {
		int price = 0;
		if(this.getDestination().equals("New York")) {
			price = 66000000;
		}else if(this.getDestination().equals("Japan")) {
			price = 44000000;
		}else {
			price = 46000000;
		}
		return price;
	}
	
	// Menghitung diskon yang di dapatkan
	@Override
	public int getDiscount() {
		int price = 0;
		int discount = 0;
		if(this.getDestination().equals("New York")) {
			price = 66000000;
			discount = (int)(price * 0.5);
		}else if(this.getDestination().equals("Japan")) {
			price = 44000000;
			discount = (int)(price * 0.4);
		}else {
			price = 46000000;
			discount = (int)(price * 0.3);
		}
		return discount;
	}
	
	
	
	
	
	
	
	
	
	

}
