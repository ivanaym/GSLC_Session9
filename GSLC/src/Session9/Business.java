package Session9;

public class Business extends Ticket implements Discount {
	
	private String lounge;

	public Business(String planeName, String departure, String destination, String date, String time,
			String flightClass, String lounge) {
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
			price = 32000000;
		}else if(this.getDestination().equals("Japan")) {
			price = 28000000;
		}else {
			price = 25000000;
		}
		return price;
	}
	
	// Menghitung diskon yang di dapatkan
	@Override
	public int getDiscount() {
		int price = 0;
		int discount = 0;
		if(this.getDestination().equals("New York")) {
			price = 32000000;
			discount = (int)(price * 0.3);
		}else if(this.getDestination().equals("Japan")) {
			price = 28000000;
			discount = (int)(price * 0.2);
		}else {
			price = 25000000;
			discount = (int)(price * 0.2);
		}
		return discount;
	}
	
	
	
	
}
