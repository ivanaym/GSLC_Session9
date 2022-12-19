package Session9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Ticket> ticketAL = new ArrayList<>();	
	
	
	String genloungeB() {
		String lounge = "BS";
		for(int i = 0;i<3;i++) {
			int temp = (int)((Math.random()*(3-1))+1);
			lounge += temp;
		}
		return lounge;
	}
	
	String genloungeF() {
		String lounge = "FI";
		for(int i = 0;i<3;i++) {
			int temp = (int)((Math.random()*(3-1))+1);
			lounge += temp;
		}
		return lounge;
	}
	
	public Main() {
		// Menampilkan menu yang akan di pilih
		int choose;
		
		do {
			System.out.println("TICKET.COM");
			System.out.println("============");
			System.out.println("1. View Tickets");
			System.out.println("2. Add New Flight");
			System.out.println("3. Buy");
			System.out.println("4. Exit");
			System.out.println("Choose:  ");
			choose = scan.nextInt();
			scan.nextLine();
			
			switch(choose) {
				case 1 : 
					viewTickets();
					break;
				case 2 :
					addNewFlight();
					break;
				case 3 :
					buy();
					break;
			}
			
		}while(choose !=4);
	}
	
	// Menampilkan jadwal pesawat yang sudah di input
	void viewTickets() { 
	
		if(ticketAL.isEmpty()) {
			System.out.println("There is no schedule");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Press enter to continue");
			scan.nextLine();
		}else {
			int count = 0;
			System.out.printf("| %-4s | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20s | %-20s | %-20s |\n",
			"No", "Plane Name", "Departure", "Destination", "Date", "Time", "Flight Class", "Seat Number", "Lounge Business", "Lounge First");
			
			for(Ticket t : ticketAL) {
				count++;
				if(t instanceof Economy) {
					System.out.printf("| %-4d | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20d | %-20s | %-20s |\n",
										count, t.getPlaneName(), t.getDeparture(), t.getDestination(), t.getDate(), t.getTime(),t.getFlightClass(),
										((Economy)t).getSeatNumber(), "-", "-");
				}else if(t instanceof Business) {
					System.out.printf("| %-4d | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20d | %-20s | %-20s |\n",
										count, t.getPlaneName(), t.getDeparture(), t.getDestination(), t.getDate(), t.getTime(),t.getFlightClass(),
										"-",((Business)t).getLounge(), "-");
				}else {
					System.out.printf("| %-4d | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20d | %-20s | %-20s |\n",
										count, t.getPlaneName(), t.getDeparture(), t.getDestination(), t.getDate(), t.getTime(),t.getFlightClass(),
										"-", "-", ((First)t).getLounge());
				}
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Press Enter to countinue");
			scan.nextLine();
		}
	}
	
	// Menambahkan jadwal pesawat ke dalam arraylist
	void addNewFlight() {
		String planeName = "";
		String departure = "";
		String destination = "";
		String date = "";
		String time = "";
		String flightClass = "";
		Integer seatNumber;
		String lounge = "";
		
		
		do {
			System.out.println("Input Plane Name [Emirates | Qatar Airways| Garuda Indonesia] : ");
			planeName = scan.nextLine();
		}while(!(planeName.equals("Emirates") || planeName.equals("Qatar Airways") || planeName.equals("Garuda Indonesia")));
		
		do {
			System.out.println("Input Departure [Jakarta] : ");
			departure = scan.nextLine();
		}while(!(departure.equals("Jakarta")));
		
		do {
			System.out.println("Input Destination [New York | German | Japan] : ");
			destination = scan.nextLine();
		}while(!(destination.equals("New York") || destination.equals("German") || destination.equals("Japan")));
		
		System.out.println("Input date : ");
		date = scan.nextLine();
		
		System.out.println("Input Time : ");
		time = scan.nextLine();
		
		do {
			System.out.println("Input Flight Class[Economy | Business Class | First Class]: ");
			flightClass = scan.nextLine();
		}while(!(flightClass.equals("Economy") || flightClass.equals("First Class") || flightClass.equals("Business Class")));
		
		
		if(flightClass.equals("Economy")){
				int temp = (int)((Math.random()*(200-1))+1);
				seatNumber = temp;
				ticketAL.add(new Economy(planeName, departure, destination, date, time, flightClass, seatNumber));
		}else if(flightClass.equals("Business Class")) {
			lounge = genloungeB();
			ticketAL.add(new Business(planeName, departure, destination, date, time, flightClass,lounge));
		}else {
			lounge = genloungeF();
			ticketAL.add(new First(planeName, departure, destination, date, time, flightClass,lounge));
		}
		
		System.out.println("A new schedule has been added");	
	}
	
	void buy(){
		if(ticketAL.isEmpty()) {
			System.out.println("There is no schedule");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Press enter to continue");
			scan.nextLine();
		}else {
			int count = 0;
			System.out.printf("| %-4s | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20s | %-20s | %-20s |\n",
			"No", "Plane Name", "Departure", "Destination", "Date", "Time", "Flight Class", "Seat Number", "Lounge Business", "Lounge First");
			
			for(Ticket t : ticketAL) {
				count++;
				if(t instanceof Economy) {
					System.out.printf("| %-4d | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20d | %-20s | %-20s |\n",
										count, t.getPlaneName(), t.getDeparture(), t.getDestination(), t.getDate(), t.getTime(),t.getFlightClass(),
										((Economy)t).getSeatNumber(), "-", "-");
				}else if(t instanceof Business) {
					System.out.printf("| %-4d | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20d | %-20s | %-20s |\n",
										count, t.getPlaneName(), t.getDeparture(), t.getDestination(), t.getDate(), t.getTime(),t.getFlightClass(),
										"-",((Business)t).getLounge(), "-");
				}else {
					System.out.printf("| %-4d | %-30s | %-20s | %-20s | %-20s | %-10s | %-20s | %-20d | %-20s | %-20s |\n",
										count, t.getPlaneName(), t.getDeparture(), t.getDestination(), t.getDate(), t.getTime(),t.getFlightClass(),
										"-", "-", ((First)t).getLounge());
				}
			}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
		
		int buy = 0;
		do {
			System.out.println("Input the flight that you want to buy [1 - " + ticketAL.size() + "]: ");
			buy = scan.nextInt();
			scan.nextLine();
		}while(buy < 1 || buy > ticketAL.size());
		
		if(ticketAL.get(buy-1)instanceof Economy) {
			System.out.println("Destination : " + ((Economy)ticketAL.get(buy-1)).getDestination());
			System.out.println("Price       : " + ((Economy)ticketAL.get(buy-1)).generatePrice());
		}else if(ticketAL.get(buy-1)instanceof Business) {
			System.out.println("Destination : " + ((Business)ticketAL.get(buy-1)).getDestination());
			System.out.println("Price       : " + ((Business)ticketAL.get(buy-1)).generatePrice());
		}else {
			System.out.println("Destination : " + ((First)ticketAL.get(buy-1)).getDestination());
			System.out.println("Price       : " + ((First)ticketAL.get(buy-1)).generatePrice());
		}
		
		int payment = 0;
		int discount = 0;
		
		// Jumlah yang harus di bayar
		System.out.println("Total Payment : "+ (ticketAL.get(buy-1).generatePrice()- discount ));
	
		System.out.println("");
		System.out.println("Thank you for buying the ticket");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		}
		
	}


	public static void main(String[] args) {
		new Main();

	}

}
