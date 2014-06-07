package com.fcg.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

import com.fcg.card.Card;

/**
 * Keeps track of selected store items
 * 
 * @author Alex
 * 
 */
public class ShopListener implements MouseListener {
	
	/**
	 * Selected card
	 */
	public static Card	selectedCard;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			Card card = (Card) arg0.getSource();
			if (selectedCard == null) {
				selectedCard = card;
				card.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
			} else {
				if (card == selectedCard) {
					card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					selectedCard = null;
				} else {
					selectedCard.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
					selectedCard.repaint();
					selectedCard = card;
					card.setBorder(BorderFactory.createLineBorder(Color.YELLOW,
							5));
				}
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
}
