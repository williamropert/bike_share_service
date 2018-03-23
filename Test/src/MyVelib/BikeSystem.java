package MyVelib;

import user.*;
import bicycle.*;

import java.util.*;

public class BikeSystem {
	private int totalStations;
	private int totalSlots;
	private double ratioFull;
	private double ratioElec;
	private List<Station> stations;
	private List<ParkingSlot> allSlots = new ArrayList<ParkingSlot>();
	private List<User> allUsers = new ArrayList<User>();
	private List<Bicycle> allBicycles = new ArrayList<Bicycle>();
	
	public BikeSystem (int totalStations, int totalSlots, double ratioFull, double ratioElec){
		this.totalStations = totalStations;
		this.totalSlots = totalSlots;
		this.ratioFull = ratioFull;
		this.ratioElec = ratioElec;
		this.stations = new ArrayList<Station>(totalStations);
		for (int i=0; i < totalStations; i++){
			stations.add(new Station(totalSlots/totalStations));
		}
		for (int k =0; k<totalSlots%totalStations; k++){
			stations.get(k).addSlot(new ParkingSlot(stations.get(k)));
		}
		for (Station k:stations){
			allSlots.addAll(k.getSlotsList());
		}
		
		/* applicate the ratioFull exactly but not open-close, have to create a SomeRatio hashset or class */
		Random rand = new Random();
		List<Integer> indexList = new ArrayList<Integer>();
		int k = 0;
		while (k< ((int)(ratioFull*this.totalSlots))){
			int m = rand.nextInt(this.allSlots.size());
			if ((allSlots.get(m).getSlotState()==ParkingSlotState.occupied)&& (!(indexList.contains(m)))){
				k++;
				indexList.add(m);
			}
			else
				if (!(indexList.contains(m))){
				indexList.add(m);
				allSlots.get(m).setSlotState(ParkingSlotState.occupied, new Bicycle());
				k++;
			}
			for (int i =0; i<this.allSlots.size();i++){
				if (!(indexList.contains(i))){
					allSlots.get(i).setSlotState(ParkingSlotState.values()[new Random().nextInt(ParkingSlotState.values().length-1)]);
				}
			}
		}
		
		for (ParkingSlot s:allSlots){
			if (s.getSlotState()== ParkingSlotState.occupied){
				this.allBicycles.add(s.getItsBicycle());
			}
		}
		/*to be sure*/
		for (Station z:this.stations){
				z.update();
			}
		
	}
	
	@Override 
	public String toString(){
		return "System [TotalStations:" + totalStations +" , totalSlots: " + totalSlots+ " , ratioFull:"+ ratioFull+ " , ratioElec:" + ratioElec + "]";  
	}
	
	public void addUser(User aUser){
		this.allUsers.add(aUser);
	}
	
	public void addStation(int additionalSlots){
		this.stations.add(new Station(additionalSlots));
		this.totalStations++;
		this.totalSlots = this.totalSlots + additionalSlots;
		
	}
	
	public void addStation(Station aStation){
		this.stations.add(aStation);
		this.totalStations++;
		this.totalSlots = this.totalSlots + aStation.getTotalParkingSlots();
		for (int i=0 ; i<aStation.getSlotsList().size(); i++){
			this.allSlots.add(aStation.getSlotsList().get(i));
			if (aStation.getSlotsList().get(i).getSlotState()== ParkingSlotState.occupied){
				this.allBicycles.add(aStation.getSlotsList().get(i).getItsBicycle());
			}
		}
		
	}
	public void removeStation(Station aStation){
		this.stations.remove(aStation);
		this.totalStations--;
		this.totalSlots = this.totalSlots - aStation.getTotalParkingSlots();
		for (int i=0 ; i<aStation.getSlotsList().size(); i++){
			this.allSlots.remove(aStation.getSlotsList().get(i));
			this.allBicycles.remove(aStation.getSlotsList().get(i).getItsBicycle());
		}
	}

	public int getTotalStations() {
		return totalStations;
	}

	public void setTotalStations(int totalStations) {
		this.totalStations = totalStations;
	}

	public int getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}

	public double getRatioFull() {
		return ratioFull;
	}

	public void setRatioFull(double ratioFull) {
		this.ratioFull = ratioFull;
	}

	public double getRatioElec() {
		return ratioElec;
	}

	public void setRatioElec(double ratioElec) {
		this.ratioElec = ratioElec;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<ParkingSlot> getAllSlots() {
		return allSlots;
	}

	public void setAllSlots(List<ParkingSlot> allSlots) {
		this.allSlots = allSlots;
	}

	public List<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}

	public List<Bicycle> getAllBicycles() {
		return allBicycles;
	}


}
