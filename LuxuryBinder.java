package com.tciss;

import com.tciss.Card.Rarity;
import com.tciss.Card.Variant;

public class LuxuryBinder  extends ValidatingCardContainer implements RestrictedCardTypes{
	private static final int MAX_CAPACITY = 20;
	private static final double TAX = 1.10;
	private Double finalPrice;
	
	public LuxuryBinder(String name) {
		super(name,MAX_CAPACITY);
		this.finalPrice = null;
	}

	@Override
	public boolean isCardAllowed(Card card) {
		return (card.getRarity() == Rarity.RARE || card.getRarity() == Rarity.LEGENDARY) && (card.getVariant() != Variant.NORMAL);
	}

	@Override
	protected void validateCard(Card card) throws InvalidCardException {
		if(!isCardAllowed(card)) {
			throw new InvalidCardException("Only rare and legendary cards with variats either extended-art, full-art and alt-art are allowed in this binder");		
		}
	}

	@Override
	public String getContainerTypeName() {
		return "Luxury Binder";
	}
	
	public boolean setFinalPrice(double price) {
	    double realValue = getPrice(1.0); // No fee — just total card value
	    if (price < realValue) {
	        return false; // Collector's price is too low
	    }
	    this.finalPrice = price;
	    return true;
	}
	
	// Gets the user-set price (or null if none)
	public Double getFinalPrice() {
	    return this.finalPrice;
	}

	// Returns the final price including handling fee
	@Override
	public double getPrice() {
	    double base;
	    if (finalPrice != null) {
	        base = finalPrice;
	    } else {
	        base = getPrice(1.0); // use default card value
	    }
	    
	    return base * TAX;
	}

}
