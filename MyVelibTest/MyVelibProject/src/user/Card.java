package user;

import ride.*;

public class Card {
	private static int counter;
	private int cardId;
	private User owner;
	private CardType type;
	private int balance;
	private int timeCredit;
	private PricingSystem pricingStrategy;
	
	public Card(String typeAsked){
		counter++;
		this.cardId = counter;
		this.type = CardType.valueOf(typeAsked);
		if (CardType.valueOf(typeAsked) == CardType.Vlibre){
			this.pricingStrategy = new VlibreCard();
		}
		else
			this.pricingStrategy = new VmaxCard();
		
		
	}
	
	public Card(String typeAsked, User owner){
		counter++;
		this.cardId = counter;
		this.type = CardType.valueOf(typeAsked);
		this.owner = owner;
		if (CardType.valueOf(typeAsked) == CardType.Vlibre){
			this.pricingStrategy = new VlibreCard();
		}
		else
			this.pricingStrategy = new VmaxCard();
	}
	
	@Override
	public String toString(){
		return "Card [Id: " + cardId + ", type: "+type+ " , owner: "+owner.getFirstName()+ " " +owner.getName()+"(User Id: "+ owner.getUserId() +")]";
	}

	public double thePrice(Ride aRide){
		return pricingStrategy.cost(aRide);
	}
	public int getCardId() {
		return cardId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getTimeCredit() {
		return timeCredit;
	}

	public void setTimeCredit(int timeCredit) {
		this.timeCredit = timeCredit;
	}

	public PricingSystem getPricingStrategy() {
		return pricingStrategy;
	}

	public void setPricingStrategy(PricingSystem pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
	}

	
}
