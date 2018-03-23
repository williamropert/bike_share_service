package ride;

import bicycle.BicycleType;

public class VmaxCard implements PricingSystem {
	@Override
	public double cost(Ride ride){
		if (ride.getDuration()<=60){
			return 0;
		}
		
		else {
			return 1* (ride.getDuration()-60)/60;
		}
					

	}

}
