package com.fcg.panels;

import javax.swing.JPanel;

import com.fcg.card.Card;
import com.fcg.card.playable.PlayableCard;

/**
 * Panel specifically created for adding card copies to gui
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class CardPanel extends JPanel {
	
	/**
	 * Make a new card panel
	 */
	public CardPanel() {
		setLayout(null);
	}
	
	/**
	 * Adds card to panel
	 * 
	 * @param par1 Card to be added
	 * @param x Horizontal location of card
	 * @param y Vertical location of card
	 */
	public void addCard(PlayableCard par1, int x, int y) {
			Card copied = par1.copy();
			System.out.println(copied.getName());
			copied.setLocation(x, y);
			add(copied);
			repaint();
	}
}
