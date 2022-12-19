package Session9;

public class Economy extends Ticket implements Discount {
	
	private Integer seatNumber;

	public Economy(String planeName, String departure, String destination, String date, String time, String flightClass, Integer seatNumber) {
		super(planeName, departure, destination, date, time, flightClass);
		this.seatNumber = seatNumber;
	}
	
	// Getter Setter
	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	// Harga tiket berdasarkan destinasi tujuan
	@Override
	public int generatePrice() {
		int price = 0;
		if(this.getDestination().equals("New York")) {
			price = 12000000;
		}else if(this.getDestination().equals("Japan")) {
			price = 6000000;
		}else {
			price = 8000000;
		}
		return price;
	}

	// Menghitung diskon yang di dapatkan
	@Override
	public int getDiscount() {
		int price = 0;
		int discount = 0;
		if(this.getDestination().equals("New York")) {
			price = 12000000;
			discount = (int)(price * 0.2);
		}else if(this.getDestination().equals("Japan")) {
			price = 6000000;
			discount = (int)(price * 0.1);
		}else {
			price = 8000000;
			discount = (int)(price * 0.1);
		}
		return discount;
	}

	

	
	
	

}
