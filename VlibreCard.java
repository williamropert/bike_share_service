package ride;

import bicycle.BicycleType;
import user.*;

public class VlibreCard implements PricingSystem {
	@Override
	public double cost(Ride ride){
		if (ride.getDuration()<=60){
			return 0;
		}
		int c = ride.getRider().getCard().getTimeCredit();
		if (c >(ride.getDuration()-60)){
			ride.getRider().getCard().setTimeCredit(c-(ride.getDuration()-60));
			return 0;
		}
		if (ride.getBicycleUsed().getType() == BicycleType.Mechanical){
			return 1* (ride.getDuration()-60)/60;
			}
		else {
			return 2*(ride.getDuration()-60)/60;
			}
			
	}

}
