package com.fcg.quest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
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
	
	@SuppressWarnings("javadoc")
	public static City		baileysCrossroads		= new City(
															"Bailey's Crossroads");
	
	@SuppressWarnings("javadoc")
	public static City		baileysCrossroadsMetro	= new City(
															"Bailey's Crossroads Metro");
	
	@SuppressWarnings("javadoc")
	public static City		outcastOutpost			= new City(
															"Outcast Outpost");
	
	/**
	 * Id of the city
	 */
	public static int		id;
	
	/**
	 * Keeps track of number of buttons in city
	 */
	public static int buttonNumber = 2;
	
	/**
	 * Keeps track of ids through city creations
	 */
	public static int		idTracker				= 0;
	
	/**
	 * Pane for all buttons to be added in city
	 */
	JPanel					buttons					= new JPanel();
	
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
	CityButton				travel					= new CityButton(
															"Travel (Quit)",
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
	 * Keeps track of whether to add new shop or not to screen
	 */
	public boolean			clickable				= true;
	
	/**
	 * Adds shop button to city
	 */
	CityButton				shop					= new CityButton(
															"Shop",
															new MouseListener() {
																
																@Override
																public void mouseClicked(
																		MouseEvent arg0) {
																	if (clickable) {
																		System.out
																				.println("Loaded Shop");
																		store("Debug Store",
																				((City) ((CityButton) arg0
																						.getSource())
																						.getParent()
																						.getParent()));
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
	 * @param name
	 *            The name of the city
	 * @param button
	 *            All buttons for display (max 5 or they won't display)
	 */
	public City(String name, CityButton... button) {
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
		JLabel cityName = new JLabel(name);
		cityName.setBounds(0, 0, getWidth(), 50);
		cityName.setFont(new Font("TimesRoman", Font.PLAIN, 32));
		cityName.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < button.length; i++) {
			button[i].setLocation(10, (100 * i + 2) + (25 * (i + 3)));
			buttons.add(button[i]);
		}
		add(cityName);
		add(buttons);
		id = idTracker;
		idTracker++;
		System.out.println("Gave id " + id + " to " + name);
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
	public void store(String name, City city) {
		CityShop par1 = new CityShop(name, city, city.getStoreItems());
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
	
	/**
	 * Gets the id of the city
	 * 
	 * @return ID in form of int
	 */
	public static int getID() {
		return id;
	}
	
	/**
	 * Adds button to city
	 * 
	 * @param button
	 */
	public void addButton(CityButton button){
		button.setLocation(10, (100 * buttonNumber) + (25 * (buttonNumber + 1)));
		buttons.add(button);
		buttonNumber++;
	}
}
