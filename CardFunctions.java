package com.tciss;

public interface CardFunctions {
	boolean addCard(Card card) throws InvalidCardException;
	Card removeCard(String cardName);
	void removeCard(Card card);
	void displayCards();
}
