package com.fcg.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import com.fcg.card.Card;

/**
 * Mouse listener for all cards
 * 
 * @author Alex
 *
 */
public class ZoomListener implements MouseListener {
	
	/**
	 * Gets mouse clicked event from card to fire {@link Card#zoom(Card father)}
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			Card card = (Card) arg0.getSource();
			
			card.zoom(card);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
