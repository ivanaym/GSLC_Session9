package Session9;

public abstract class Ticket {
	
	private String planeName = "";
	private String departure = "";
	private String destination = "";
	private String date = "";
	private String time = "";
	private String flightClass = "";
	
	public Ticket(String planeName, String departure, String destination, String date, String time, String flightClass) {
		super();
		this.planeName = planeName;
		this.departure = departure;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.flightClass = flightClass;

	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public abstract int generatePrice();
	
	

}
