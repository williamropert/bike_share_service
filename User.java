package user;

import java.util.*;

import location.*;
import bicycle.*;
import MyVelib.*;
import ride.*;
import java.lang.*;
import ride.*;

public class User {
	private static int counter;
	private int userId;
	private String name;
	private String firstName;
	private int totalRides;
	private double totalTimeOnBike;
	private Coordinates userLocation;
	private List<Ride> hisRides = new ArrayList<Ride>();
	Card card;
	private Bicycle bikeRented;
	private PricingSystem pricingSystem;
	private double totalAmountCharges ;
	
	public User(String firstName, String name, Card card){
		this.firstName = firstName;
		this.name = name;
		counter++;
		this.userId = counter;
		this.card = card;
		this.card.setOwner(this);
		this.userLocation = new Coordinates();
		this.pricingSystem = card.getPricingStrategy();
		
	}
	
	public User(String firstName, String name){
		this.firstName = firstName;
		this.name = name;
		counter++;
		this.userId = counter;
		this.userLocation = new Coordinates();
		this.pricingSystem = new NoCard();
	}
	
	@Override
	public String toString(){
		if (card==null){
			return "User [ID : " + userId + ", full name: " + firstName + " " + name + ", Card: None]";
		}
		else{
			return "User [ID : " + userId + ", full name: " + firstName + " " + name + ", Card: " + card.getType() +"]";
		}
	}
	
	public void applyStrategy(){
		
	}
	
	public void addCard(Card aCard){
		if (card==null){
			this.card = aCard;
			this.card.setOwner(this);
			if (card.getType() == CardType.Vlibre){
				this.pricingSystem = new VlibreCard();
			}
			else
				this.pricingSystem = new VmaxCard();
		}
	}
	
	public void addCard(String aCardType){
		if (card==null){
			this.card = new Card(aCardType);
			this.card.setOwner(this);
		}
		if (CardType.valueOf(aCardType) == CardType.Vlibre){
			this.pricingSystem = new VlibreCard();
		}
		else
			this.pricingSystem = new VmaxCard();
	}
	
	public void rent(Station aStation, BicycleType aTypeOfBike){
		if (this.bikeRented == null){
			int s =0;
			for (ParkingSlot g:aStation.getSlotsList()){	
				if (s<1){
					if (g.getSlotState()==ParkingSlotState.occupied){
						if (g.getItsBicycle().getType()== aTypeOfBike){
							s++;
							this.bikeRented= g.getItsBicycle();
							this.bikeRented.setState(BicycleState.rented);
							this.bikeRented.setSourceSlot(g);
							g.setSlotState(ParkingSlotState.free);
												
						}
					}
				}}
			if (s==0){
				System.out.println("The station has no bicycle of the desired type.");
			}
		}
		
		else
			System.out.println("The user is already renting a bike.");
	}
	
	public void returnBike(Station anotherStation){
		if (this.bikeRented==null){
			System.out.println("The user has not rented any bike.");
		}
		else
			if (anotherStation.getState()==StationState.OFF){
				System.out.println("The bike cannot be returned to this station because it is offline.");
			}
			else {
				int t=0 ;
				for (ParkingSlot s:anotherStation.getSlotsList()){
					if (t<1){
						if (s.getSlotState()==ParkingSlotState.free){
							t++;
							Ride aRide = new Ride(this, this.bikeRented,this.bikeRented.getSourceSlot().getItsStation(), anotherStation);
							this.hisRides.add(aRide);
							this.bikeRented.setState(BicycleState.parked);
							this.bikeRented.setParkedSlot(s);
							s.setSlotState(ParkingSlotState.occupied);
							s.setItsBicycle(this.bikeRented);
						}
					}
				}
				if (t==0){
					System.out.println("The station has no free slot where the user can park its bike.");
				}
	}}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getTotalRides() {
		return totalRides;
	}

	public void setTotalRides(int totalRides) {
		this.totalRides = totalRides;
	}

	public double getTotalTimeOnBike() {
		return totalTimeOnBike;
	}

	public void setTotalTimeOnBike(double totalTimeOnBike) {
		this.totalTimeOnBike = totalTimeOnBike;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Coordinates getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(Coordinates userLocation) {
		this.userLocation = userLocation;
	}

	public List<Ride> getHisRides() {
		return hisRides;
	}

	public void setHisRides(List<Ride> hisRides) {
		this.hisRides = hisRides;
	}

	public Bicycle getBikeRented() {
		return bikeRented;
	}

	public void setBikeRented(Bicycle bikeRented) {
		this.bikeRented = bikeRented;
	}

	public PricingSystem getPricingSystem() {
		return pricingSystem;
	}

	public void setPricingSystem(PricingSystem pricingSystem) {
		this.pricingSystem = pricingSystem;
	}
	
	public double getTotalAmountCharges() {
		return totalAmountCharges;
	}
	
	public void setTotalAmountCharges(double totalAmountCharges) {
		this.totalAmountCharges = totalAmountCharges;
	}
	
	
	

}