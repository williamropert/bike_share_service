package MyVelib;

import user.*;

import java.util.*;

import bicycle.BicycleType;
import location.*;


public class Test {
	public static void main(String[] args) {
		BikeSystem myFirstVelib = new BikeSystem(2,10,0.5,0.1);
		User user1 = new User("William","Ropert",new Card("Vmax"));
		myFirstVelib.addUser(user1);
		System.out.println(myFirstVelib.getStations());
		System.out.println(myFirstVelib.getAllSlots());
		user1.rent(myFirstVelib.getStations().get(0), BicycleType.Electrical);
		System.out.println(myFirstVelib.getAllBicycles());
		System.out.println(myFirstVelib.getAllSlots());
		user1.returnBike(myFirstVelib.getStations().get(1));
		System.out.println(myFirstVelib.getAllBicycles());
		System.out.println(myFirstVelib.getAllSlots());
		System.out.println(user1.getHisRides());
		/*BikeSystem myFirstVelib = new BikeSystem(6,10,0.5,0.1);
		System.out.println(myFirstVelib.getStations());
		System.out.println(myFirstVelib.getAllSlots());
		myFirstVelib.getStations().get(1).getSlotsList().get(0).setSlotState(ParkingSlotState.out);
		myFirstVelib.getStations().get(1).getSlotsList().get(1).setSlotState(ParkingSlotState.out);
		System.out.println(myFirstVelib.getStations());
		System.out.println(myFirstVelib.getAllSlots());
		System.out.println(myFirstVelib.getAllBicycles());
		/*PlusStation station1 = new PlusStation(1);
		myFirstVelib.addStation(station1);
		System.out.println(myFirstVelib.toString());
		System.out.println(myFirstVelib.getStations());
		System.out.println(myFirstVelib.getAllSlots());
		User user1 = new User("William","Ropert");
		myFirstVelib.addUser(user1);
		User user2 = new User("Carole", "El-Kurdi",new Card("Vmax"));
		myFirstVelib.addUser(user2);
		System.out.println(myFirstVelib.getAllBicycles());
		System.out.println(myFirstVelib.getAllBicycles().size());
		
		RentABike rent1 = new RentABike(user1,myFirstVelib.getAllBicycles().get(2));
		
		System.out.println(myFirstVelib.getAllBicycles());
		System.out.println(myFirstVelib.getAllSlots());
		ReturnABike return1 = new ReturnABike(user1, myFirstVelib.getAllBicycles().get(2), myFirstVelib.getAllSlots().get(6));
		System.out.println(myFirstVelib.getAllBicycles());
		System.out.println(myFirstVelib.getAllSlots());
	
		/*System.out.println(myFirstVelib.getAllUsers());
		Card card1 = new Card ("Vlibre");
		user1.addCard(card1);
		System.out.println(user1);
		System.out.println(myFirstVelib.getAllUsers());
		System.out.println(card1);
		System.out.println(user2.getCard());*/
		
		/*System.out.println(myFirstVelib.getStations());
		System.out.println(myFirstVelib.getStations().get(0).getSlotsList());
		System.out.println(myFirstVelib.getAllSlots());
		System.out.println(myFirstVelib.getStations().get(1).getSlotsList());
		System.out.println(myFirstVelib.getStations().get(2).getSlotsList());
		myFirstVelib.getStations().get(1).addSlot();
		System.out.println(myFirstVelib.getStations().get(1).getSlotsList());
		System.out.println(myFirstVelib.getStations());
		System.out.println(myFirstVelib.toString());
		PlusStation first = new PlusStation(8);
		StandardStation second = new StandardStation(12);
			
		System.out.println(first.toString());
		System.out.println(second.toString());
		System.out.println(second.getSlotsList());
		first.setState(StationState.OFF);
		System.out.println(first.toString()); */
		
	}
}
