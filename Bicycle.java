package bicycle;

import java.util.Random;
import MyVelib.*;

public class Bicycle {
	private static int bcounter = 0;
	private int bicycleId;
	private BicycleType type;
	private ParkingSlot parkedSlot;
	private Station parkedStation;
	private BicycleState state;
	private ParkingSlot sourceSlot;
	
	public Bicycle(){
		bcounter++;
		this.bicycleId = bcounter;
		this.type = BicycleType.values()[new Random().nextInt(BicycleType.values().length)];
		this.state = BicycleState.parked;
	}
	
	public Bicycle(String itsType){
		bcounter++;
		this.bicycleId = bcounter;
		this.type = BicycleType.valueOf(itsType);
		this.state = BicycleState.parked;
	}
	
	@Override
	public String toString(){
		return "Bicycle [Id: "+ bicycleId + " , type: " + type + " , state: " + state +"]";
	}

	public int getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(int bicycleId) {
		this.bicycleId = bicycleId;
	}

	public BicycleType getType() {
		return type;
	}

	public void setType(BicycleType type) {
		this.type = type;
	}

	
	public BicycleState getState() {
		return state;
	}

	public void setState(BicycleState state) {
		this.state = state;
	}

	public ParkingSlot getParkedSlot() {
		return parkedSlot;
	}

	public void setParkedSlot(ParkingSlot parkedSlot) {
		this.parkedSlot = parkedSlot;
		this.parkedStation = parkedSlot.getItsStation();
	}

	public Station getParkedStation() {
		return parkedStation;
	}

	public void setParkedStation(Station parkedStation) {
		this.parkedStation = parkedStation;
	}

	public ParkingSlot getSourceSlot() {
		return sourceSlot;
	}

	public void setSourceSlot(ParkingSlot sourceSlot) {
		this.sourceSlot = sourceSlot;
	}
}
