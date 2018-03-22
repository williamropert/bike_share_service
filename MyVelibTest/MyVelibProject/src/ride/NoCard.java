package ride;

import bicycle.BicycleType;

public class NoCard implements PricingSystem {
	@Override
	public double cost(Ride ride){
		if (ride.getBicycleUsed().getType() == BicycleType.Mechanical){
			return 1*(ride.getDuration()/60);
		}
		else {
			return 2*(ride.getDuration()/60);
		}
	}
}
