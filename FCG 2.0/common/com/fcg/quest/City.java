package com.fcg.quest;

import java.awt.Color;

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
	JPanel	buttons	= new JPanel();
	
	/**
	 * Keeps track of all cards available in store
	 */
	private Card[] storeCards;
	/**
	 * Make a new location
	 * 
	 * @param button All buttons for display
	 */
	public City(CityButton...button) {
		setLayout(null);
		setBackground(Color.GREEN);
		buttons.setLayout(null);
		buttons.setOpaque(false);
		setBounds(0, 0, FCG.game.getWidth(), FCG.game.getHeight());
		buttons.setBounds(FCG.game.getWidth() - 150, 0, 150, FCG.game.getHeight());
		for(int i = 0; i < 7; i++){
			button[i].setLocation(10, (100 * i) + (25 * (i + 1)));
			buttons.add(button[i]);
		}
		add(buttons);
	}
	
	/**
	 * Sets up city store
	 * 
	 * @param name Name of store
	 */
	public void store(String name){
		
	}
	
	/**
	 * Sets the store cards
	 * 
	 * @param cards Cards to be sold in city store
	 */
	public void setStoreItems(Card...cards){
		storeCards = new Card[cards.length];
		storeCards = cards;
	}
	
	/**
	 * Gets all cards sold in city store
	 * 
	 * @return Array of all cards sold in store
	 */
	public Card[] getStoreItems(){
		return storeCards;
	}
	
}
