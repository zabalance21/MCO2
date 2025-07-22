package com.tciss;

import com.tciss.Card.Rarity;

public class RareBinder  extends ValidatingCardContainer implements RestrictedCardTypes{
	private static final int MAX_CAPACITY = 20;
	private static final double TAX = 1.10;
	
	public RareBinder(String name) {
		super(name,MAX_CAPACITY);
	}
	
	@Override
	public String getContainerTypeName() {
        
		return "Rare Binder";
    }

	@Override
	public boolean isCardAllowed(Card card) {
		return card.getRarity() == Rarity.RARE || card.getRarity() == Rarity.LEGENDARY;
	}
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice(TAX);
	}

	@Override
	protected void validateCard(Card card) throws InvalidCardException {
		if(!isCardAllowed(card)) {
			throw new InvalidCardException("Only rare and legendary cards are allowed in this binder");
        }		
	}

}
