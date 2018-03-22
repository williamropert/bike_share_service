package MyVelib;

import java.util.*;
import bicycle.*;
import location.*;

public class Station implements Observer{

	private static int counter;
	private int stationId;
	private StationType type;
	private int totalParkingSlots;
	private List<ParkingSlot> slotsList;
	private StationState state;
	private Coordinates stationLocation;
	private int nbRents;
	private int nbReturns;

	
	public Station(int totalParkingSlots){
		Station.counter++;
		this.stationId = Station.counter;
		this.type = StationType.values()[new Random().nextInt(StationType.values().length)];
		this.totalParkingSlots = totalParkingSlots;
		this.slotsList = new ArrayList<ParkingSlot>(totalParkingSlots);
		for (int j=0; j< totalParkingSlots; j++){
			slotsList.add(new ParkingSlot(this));
		}
		this.state = StationState.ON;
		this.stationLocation = new Coordinates();
	}
	
	public Station(String askedType, int totalParkingSlots){
		this.type = StationType.valueOf(askedType);
		Station.counter++;
		this.stationId = Station.counter;
		this.type = StationType.values()[new Random().nextInt(StationType.values().length)];
		this.totalParkingSlots = totalParkingSlots;
		this.state = StationState.ON;
		this.slotsList = new ArrayList<ParkingSlot>(totalParkingSlots);
		for (int j=0; j< totalParkingSlots; j++){
			slotsList.add(new ParkingSlot(this));
		}
		this.stationLocation = new Coordinates();
	}
	
	/*public void setState(StationState state){
		this.state= state;
		this.notifyObservers();
	}*/
	
	public void addSlot(){
		this.slotsList.add(new ParkingSlot(this));
		this.totalParkingSlots++;
		this.update();
	}
	/* careful because this slot has to have the correct stationId when created to be added to a station*/
	public void addSlot(ParkingSlot aslot){
		this.slotsList.add(aslot);
		this.totalParkingSlots++;
		this.update();
	}
	/* parkingslot has to be in the station to be removed*/
	public void removeSlot(ParkingSlot aslot){
		this.slotsList.remove(aslot);
		this.totalParkingSlots--;
		this.update();
	}
	
	@Override
	public String toString(){
		return "Station [Id: " + stationId + ", type: " + type + ", totalSlots: " + totalParkingSlots + ", state :" + state + " , location " + stationLocation + "]" +"\n";
	}
	
	public void setState(StationState state) {
		this.state = state;
	}
	
	@Override
	public void update(){
		int numberofOut = 0;
		for (int kk=0; kk<this.slotsList.size(); kk++){
			if (this.slotsList.get(kk).getSlotState()==ParkingSlotState.out){
				numberofOut++;
				}
			}
		if (numberofOut ==this.slotsList.size()){
			this.setState(StationState.OFF);
		}
		else
			this.setState(StationState.ON);
		}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Station.counter = counter;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public StationType getType() {
		return type;
	}

	public void setType(StationType type) {
		this.type = type;
	}

	public int getTotalParkingSlots() {
		return totalParkingSlots;
	}

	public void setTotalParkingSlots(int totalParkingSlots) {
		this.totalParkingSlots = totalParkingSlots;
	}

	public StationState getState() {
		return state;
	}

	public List<ParkingSlot> getSlotsList() {
		return slotsList;
	}

	public void setSlotsList(List<ParkingSlot> slotsList) {
		this.slotsList = slotsList;
	}

	public Coordinates getStationLocation() {
		return stationLocation;
	}

	public void setStationLocation(Coordinates stationLocation) {
		this.stationLocation = stationLocation;
	}

	public int getNbRents() {
		return nbRents;
	}
	
	public void setNbRents(int nbRents) {
		this.nbRents = nbRents;
	}
	
	public int getNbReturns() {
		return nbReturns;
	}
	
	public void setNbReturns(int nbReturns) {
		this.nbReturns = nbReturns;
	}
	
	
	
}
