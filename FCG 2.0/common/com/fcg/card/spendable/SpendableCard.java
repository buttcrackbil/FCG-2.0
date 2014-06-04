package com.fcg.card.spendable;

import com.fcg.card.Card;

/**
 * [WIP] Main class for all "land" and single-use cards
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public abstract class SpendableCard extends Card {
	
	/**
	 * [WIP] Makes a card with no cost or description
	 * 
	 * @param par1
	 */
	public SpendableCard(String par1) {
		super(par1);
	}

	@Override
	public abstract Card copy();
	
}
