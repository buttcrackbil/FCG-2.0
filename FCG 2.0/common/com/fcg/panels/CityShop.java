package com.fcg.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.fcg.card.Card;
import com.fcg.listeners.ShopListener;

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
	 * Whether or not shop is out
	 */
	boolean		out;
	
	/**
	 * Constructor for shop
	 * 
	 * @param cards Cards to be displayed (usually city store items)
	 */
	public CityShop(Card... cards) {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBorder(BorderFactory.createEtchedBorder());
		int par1 = 0;
		int c = cards.length;
		while(c >= 3){
			c = c - 3;
			System.out.println(c);
			par1++;
		}
		
		if(c != 0){
			par1++;
		}
		System.out.println(par1);
		int height = ((par1 * 250) + 30);
		this.panel.setPreferredSize(new Dimension(525, height));
		this.panel.setBackground(Color.BLUE);
		
		int cardTrack = 0;
		int j = 0;
		if (!out) {
			for (int i = 0; i < cards.length; i++) {
				Card card = cards[i].copy();
				card.addMouseListener(new ShopListener());
				card.setLocation(16 + (175 * j), (250 * cardTrack) + 30);
				this.panel.add(card);
				this.panel.repaint();
				j++;
				if (j == 3) {
					j -= 3;
					cardTrack++;
				}
			}
			out = true;
		} else {
//			Remove from city
			out = false;
		}
		
		scrollPane = new JScrollPane(this.panel);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(525, 750));
		add(scrollPane);
	}
}
