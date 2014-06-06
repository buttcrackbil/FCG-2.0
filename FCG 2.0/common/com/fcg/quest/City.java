package com.fcg.quest;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fcg.FCG;
import com.fcg.card.Card;
import com.fcg.labels.CityButton;

/**
 * [WIP] Class for cities found while questing
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class City extends JPanel {
	
	/**
	 * Pane for all buttons to be added in city
	 */
	JPanel			buttons	= new JPanel();
	
	/**
	 * The panel that the store is displayed on
	 */
	JPanel storePanel = new JPanel();
	
	/**
	 * Adds button to travel to other areas
	 */
	CityButton		travel	= new CityButton("Travel", new MouseListener() {
								
								@Override
								public void mouseClicked(MouseEvent arg0) {
									System.out.println("Clicked go to button");
									System.exit(0);
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
								
							});
	
	/**
	 * Adds shop button to city
	 */
	CityButton		shop	= new CityButton("Shop", new MouseListener() {
								
								boolean	out;
								
								@Override
								public void mouseClicked(MouseEvent arg0) {
									if (!out) {
										System.out.println("Loaded Shop");
										store("Debug Store", out);
										out = true;
									} else {
										store("Debug Store", out);
										out = false;
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
							});
	
	/**
	 * Keeps track of all cards available in store
	 */
	private Card[]	storeCards;
	
	/**
	 * Make a new location
	 * 
	 * @param button
	 *            All buttons for display (max 5 or they won't display)
	 */
	public City(CityButton... button) {
		setLayout(null);
		setBackground(Color.GREEN);
		buttons.setLayout(null);
		buttons.setOpaque(false);
		setBounds(0, 0, FCG.game.getWidth(), FCG.game.getHeight());
		buttons.setBounds(FCG.game.getWidth() - 150, 0, 150,
				FCG.game.getHeight());
		buttons.add(travel);
		travel.setLocation(10, 25);
		buttons.add(shop);
		shop.setLocation(10, 150);
		for (int i = 0; i < button.length; i++) {
			button[i].setLocation(10, (100 * i + 2) + (25 * (i + 3)));
			buttons.add(button[i]);
		}
		add(buttons);
	}
	
	/**
	 * Sets up city store
	 * 
	 * @param name
	 *            Name of store
	 * @param out
	 *            boolean of whether or not to remove or display the store
	 */
	public void store(String name, boolean out) {
		if (!out) {
			storePanel.removeAll();
			storePanel.setBounds(25, 25, 500, 725);
			storePanel.setBackground(Color.blue);
			storePanel.setLayout(null);
			int cardTrack = 0;
			int j = 0;
			for (int i = 0; i < getStoreItems().length; i++) {
				Card card = getStoreItems()[i].copy();
				card.setLocation(175 * j, 250 * cardTrack);
				storePanel.add(card);
				j++;
				if (j == 3) {
					j -= 3;
					cardTrack++;
				}
			}
			add(storePanel);
			storePanel.repaint();
			repaint();
		}else{
			remove(storePanel);
			repaint();
		}
	}
	
	/**
	 * Sets the store cards
	 * 
	 * @param cards
	 *            Cards to be sold in city store
	 */
	public void setStoreItems(Card... cards) {
		storeCards = new Card[cards.length];
		storeCards = cards;
	}
	
	/**
	 * Gets all cards sold in city store
	 * 
	 * @return Array of all cards sold in store
	 */
	public Card[] getStoreItems() {
		return storeCards;
	}
	
}
