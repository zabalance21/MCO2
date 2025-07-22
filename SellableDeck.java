package com.tciss;

public class SellableDeck extends CardContainer{
    private static final int MAX_CAPACITY = 10;
    
	public SellableDeck(String name) {
		super(name, MAX_CAPACITY);
		this.isSellable = false;
	}
	
	public double getPrice(double tax) {  // ADDITION OF VALUES W/TAX OR W/0 TAX
		double total = 0.0;
	    for (int i = 0; i < cardCount; i++) {
	        total += cards[i].getTotalValue();
	    }
	    return total * tax;
	}
	
	@Override
	public String getContainerTypeName() {
		return "Sellable Deck";
	}

}
