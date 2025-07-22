package com.tciss;

import com.tciss.Card.Rarity;

public class PauperBinder extends ValidatingCardContainer implements RestrictedCardTypes{  // subclass of ValidatingCardContainer
	private static final int MAX_CAPACITY = 20;
	private static final double TAX = 1.00;

    /**
     * Constructor for Pauper Binder
     *
     * @param name the name of the binder
     */
    public PauperBinder(String name) {
        super(name,MAX_CAPACITY);
    }
	public String getContainerTypeName() {
        
		return "Pauper Binder";
    }

	@Override
	public boolean isCardAllowed(Card card) {
		return card.getRarity() == Rarity.COMMON || card.getRarity() == Rarity.UNCOMMON;
	}
	@Override
	protected void validateCard(Card card) throws InvalidCardException {
		if(!isCardAllowed(card)) {
			throw new InvalidCardException("Only common and uncommon cards are allowed in this binder");
        }
    }
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice(TAX);
	}

}
