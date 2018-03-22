package location;

import java.util.*;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Coordinates(){
		this.x = -100 + new Random().nextInt(201);
		this.y = -100 + new Random().nextInt(201);
	}
	
	@Override
	public String toString(){
		return "(X:"+ this.x + " ,Y:" + this.y +")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
