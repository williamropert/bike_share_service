package ride;

import bicycle.*;
import MyVelib.*;
import user.*;
import java.lang.Math.*;

public class Ride {
	private int duration;
	private double distance;
	private double rideCost;
	private Bicycle bicycleUsed;
	private Station departureStation;
	private Station destinationStation;
	private User rider;
	
	public Ride(User rider, Bicycle bike, Station departure, Station destination){
		this.rider = rider;
		this.bicycleUsed = bike;
		this.departureStation = departure;
		this.destinationStation = destination;
		this.distance = Math.hypot((departure.getStationLocation().getX()-destination.getStationLocation().getX()),(departure.getStationLocation().getY()-destination.getStationLocation().getY()));
		if (bike.getType()==BicycleType.Mechanical){
			this.duration = (int)(this.distance*4);
		}
		else
			this.duration = (int)(this.distance*3);
	}
	
	public void totalCost (User rider) {
		rider.setTotalAmountCharges(this.getRideCost()+1);
	}
	
	public Ride(User rider, Bicycle bike, Station departure){
		this.rider = rider;
		this.bicycleUsed = bike;
		this.departureStation = departure;
	}
	
	public void countRents (Station departureStation) {
		departureStation.setNbRents( departureStation.getNbRents()+1);
	}
	
	public void countReturns (Station destinationStation) {
		destinationStation.setNbReturns( destinationStation.getNbReturns()+1);
	}

	
	@Override
	public String toString(){
		return "Ride from " + this.departureStation + " to " + this.destinationStation +" , (duration : "+ this.duration + " , cost: "+this.getRideCost() +")";
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRideCost() {
		return this.rider.getPricingSystem().cost(this);
	}

	public void setRideCost(double rideCost) {
		this.rideCost = rideCost;
	}

	public Bicycle getBicycleUsed() {
		return bicycleUsed;
	}

	public void setBicycleUsed(Bicycle bicycleUsed) {
		this.bicycleUsed = bicycleUsed;
	}

	public Station getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}

	public Station getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}

	public User getRider() {
		return rider;
	}

	public void setRider(User rider) {
		this.rider = rider;
	}


	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
