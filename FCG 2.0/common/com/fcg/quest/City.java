package com.fcg.quest;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.fcg.FCG;
import com.fcg.card.Card;
import com.fcg.labels.CityButton;
import com.fcg.panels.CityShop;

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
	JPanel					buttons		= new JPanel();
	
	/**
	 * The panel that the store is displayed on
	 */
	JScrollPane				storePanel;
	
	/**
	 * Frame containing shop
	 */
	public JInternalFrame	panel;
	
	/**
	 * Adds button to travel to other areas
	 */
	CityButton				travel		= new CityButton("Travel",
												new MouseListener() {
													
													@Override
													public void mouseClicked(
															MouseEvent arg0) {
														System.out
																.println("Clicked travel button");
														System.exit(0);
													}
													
													@Override
													public void mouseEntered(
															MouseEvent arg0) {
													}
													
													@Override
													public void mouseExited(
															MouseEvent arg0) {
													}
													
													@Override
													public void mousePressed(
															MouseEvent arg0) {
													}
													
													@Override
													public void mouseReleased(
															MouseEvent arg0) {
													}
													
												});
	
	/**
	 * Keeps track of whether to add new shop or  not to screen
	 */
	public boolean			clickable	= true;
	
	/**
	 * Adds shop button to city
	 */
	CityButton				shop		= new CityButton("Shop",
												new MouseListener() {
													
													boolean	out;
													
													@Override
													public void mouseClicked(
															MouseEvent arg0) {
														if (clickable) {
															System.out
																	.println("Loaded Shop");
															store("Debug Store",
																	out,
																	((City) ((CityButton) arg0
																			.getSource())
																			.getParent()
																			.getParent()));
															out = true;
															clickable = false;
														}
													}
													
													@Override
													public void mouseEntered(
															MouseEvent arg0) {
													}
													
													@Override
													public void mouseExited(
															MouseEvent arg0) {
													}
													
													@Override
													public void mousePressed(
															MouseEvent arg0) {
													}
													
													@Override
													public void mouseReleased(
															MouseEvent arg0) {
													}
												});
	
	/**
	 * Keeps track of all cards available in store
	 */
	private Card[]			storeCards;
	
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
	 * @param city
	 *            This city. Must be pushed through
	 */
	public void store(String name, boolean out, City city) {
		CityShop par1 = new CityShop(city, city.getStoreItems());
		panel = new JInternalFrame();
		((BasicInternalFrameUI) panel.getUI()).setNorthPane(null);
		panel.setBackground(Color.BLACK);
		panel.setSize(510, 800);
		panel.getContentPane().add(par1);
		panel.setLocation(25, 25);
		city.add(panel);
		panel.setVisible(true);
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
