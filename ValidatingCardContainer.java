package com.tciss;

public abstract class ValidatingCardContainer extends CardContainer{ // Subclass of CardContainer, these are the binders with restrictions
	public ValidatingCardContainer(String name, int maxCapacity) {
		super(name, maxCapacity);
		this.isSellable = true;
	}

	@Override
    public boolean addCard(Card card) throws InvalidCardException {
        validateCard(card);
        return super.addCard(card);
    }
	
	public double getPrice(double tax) {  // ADDITION OF VALUES W/TAX OR W/0 TAX
		double total = 0.0;
	    for (int i = 0; i < cardCount; i++) {
	        total += cards[i].getTotalValue();
	    }
	    return total * tax;
	}
	
	// CALLS THE FIRST GETPRICE METHOD WITH THE DEFAULT TAX. TAX IS OVERRIDEN DEPENDING ON THE BINDER TYPE
	public double getPrice() {
	    return getPrice(1.0); // DEFAULT TAX 
	   
	}
    
    protected abstract void validateCard(Card card) throws InvalidCardException;

}
