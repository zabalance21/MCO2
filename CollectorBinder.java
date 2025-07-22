package com.tciss;

import com.tciss.Card.Rarity;
import com.tciss.Card.Variant;

public class CollectorBinder extends CardContainer implements RestrictedCardTypes{
	private static final int MAX_CAPACITY = 20;
	public CollectorBinder(String name) {
		super(name,MAX_CAPACITY);
		this.isSellable = false;
	}

	@Override
	public boolean isCardAllowed(Card card) {
		return (card.getRarity() == Rarity.RARE || card.getRarity() == Rarity.LEGENDARY) && (card.getVariant() != Variant.NORMAL);
	}
	
	public void validateCard(Card card) throws InvalidCardException {
		if(!isCardAllowed(card)) {
			throw new InvalidCardException("Only rare and legendary cards with variats either extended-art, full-art and alt-art are allowed in this binder");		
		}
	}

	@Override
	public String getContainerTypeName() {
		return "Collector Binder";
	}

}
