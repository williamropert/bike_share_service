package planning;

import location.*;
import MyVelib.*;
import java.util.*;


public abstract class Policy {
	public int distance (Coordinates a, Coordinates b){
		return (int) Math.hypot(a.getX()-b.getX(), a.getY()-b.getY());
	}
	
	public abstract List<Station> findStations();
}
