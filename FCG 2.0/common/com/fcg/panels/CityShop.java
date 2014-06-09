package com.fcg.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.fcg.card.Card;
import com.fcg.listeners.ShopListener;
import com.fcg.quest.City;

/**
 * A Panel with a scroll pane on it
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class CityShop extends JPanel {
	
	/**
	 * Panel in scroll pane with cards on it
	 */
	JPanel		panel;
	
	/**
	 * Pane that panel is located in
	 */
	JScrollPane	scrollPane;
	
	/**
	 * Button that removes shop from view
	 */
	JButton		cancelButton	= new JButton("Cancel");
	
	/**
	 * Buys the selected card
	 */
	JButton		buyButton		= new JButton("Buy");
	
	/**
	 * Whether or not shop is out
	 */
	boolean		out;
	
	/**
	 * The containing city
	 */
	public City	cityCon;
	
	/**
	 * Constructor for shop
	 * 
	 * @param name
	 *            Name of the store in the city
	 * @param city
	 *            City that this shop is on
	 * @param cards
	 *            Cards to be displayed (usually city store items)
	 */
	public CityShop(String name, City city, Card... cards) {
		cityCon = city;
		cancelButton.setSize(100, 20);
		buyButton.setSize(100, 20);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cityCon.panel.setVisible(false);
				cityCon.clickable = true;
			}
			
		});
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ShopListener.selectedCard != null) {
					System.out.println(ShopListener.selectedCard.getName());
				}
			}
			
		});
		this.panel = new JPanel();
		this.panel.setLayout(null);
		JLabel label = new JLabel(name);
		int par1 = 0;
		int c = cards.length;
		while (c >= 3) {
			c = c - 3;
			par1++;
		}
		
		if (c != 0) {
			par1++;
		}
		int height = ((par1 * 250) + 30);
		this.panel.setPreferredSize(new Dimension(525, height));
		this.panel.setBackground(Color.LIGHT_GRAY);
		label.setBounds((this.panel.getPreferredSize().width - 100) / 2, 0,
				100, 20);
		this.panel.add(label);
		
		int cardTrack = 0;
		int j = 0;
		for (int i = 0; i < cards.length; i++) {
			Card card = cards[i].copy();
			card.addMouseListener(new ShopListener());
			card.setLocation(24 + (175 * j), (250 * cardTrack) + 30);
			this.panel.add(card);
			this.panel.repaint();
			j++;
			if (j == 3) {
				j -= 3;
				cardTrack++;
			}
		}
		
		scrollPane = new JScrollPane(this.panel);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(550, 750));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane);
		add(cancelButton);
		add(buyButton);
	}
}
