package com.fcg.card.spendable;

import com.fcg.card.Card;

/**
 * [WIP] Ammo, rads, and stamina cards
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class LandCard extends SpendableCard {

	/**
	 * Makes land card
	 * 
	 * @param par1 Name of card
	 */
	public LandCard(String par1) {
		super(par1);
	}

	@Override
	public Card copy() {
		return null;
	}
	
}
