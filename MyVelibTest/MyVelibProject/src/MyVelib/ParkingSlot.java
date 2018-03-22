package MyVelib;

import java.util.Random;
import bicycle.*;

public class ParkingSlot implements Observable {
	public static int counter;
	private int slotId;
	private ParkingSlotState slotState;
	private Station itsStation;
	private Bicycle itsBicycle;
	
	public ParkingSlot(Station itsStation){
		this.itsStation = itsStation;
		ParkingSlot.counter++;
		this.slotId = ParkingSlot.counter;
		this.slotState = ParkingSlotState.values()[new Random().nextInt(ParkingSlotState.values().length)];
		if (this.slotState == ParkingSlotState.occupied){
			this.itsBicycle = new Bicycle();
			this.itsBicycle.setParkedSlot(this);
		}
	}
	
	@Override
	public String toString(){
		if (this.slotState == ParkingSlotState.occupied){
			return "Slot [stationId: "+ itsStation.getStationId() + " , slotId: "+slotId + " , state: "+slotState + " with " + this.itsBicycle +" ]" + "\n";
		}
		else{
			return "Slot [stationId: "+ itsStation.getStationId() + " , slotId: "+slotId + " , state: "+slotState + " ]" + "\n";
		}
	}

	
	@Override
	public void notifyObservers(){
		this.itsStation.update();
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public ParkingSlotState getSlotState() {
		return slotState;
	}

	public void setSlotState(ParkingSlotState slotState) {
		this.slotState = slotState;
		this.notifyObservers();
	}
	
	public void setSlotState(ParkingSlotState slotState, Bicycle anotherBicycle) {
		this.slotState = slotState;
		this.itsBicycle = anotherBicycle;
		this.notifyObservers();
	}

	public Station getItsStation() {
		return itsStation;
	}

	public void setItsStation(Station aStation) {
		this.itsStation = aStation;
	}

	public Bicycle getItsBicycle() {
		return itsBicycle;
	}

	public void setItsBicycle(Bicycle itsBicycle) {
		this.itsBicycle = itsBicycle;
	}
}
