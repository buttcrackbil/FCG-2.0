package com.fcg.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.fcg.listeners.ZoomListener;

/**
 * Main class for all cards in game
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public abstract class Card extends JPanel {
	
	/**
	 * Name of card
	 */
	protected String		name;
	
	/**
	 * Label that displays name
	 */
	public JLabel			nameLabel	= new JLabel();
	
	/**
	 * Array to keep all cards in one spot
	 */
	public static Card[]	cardList	= new Card[100];
	
	/**
	 * The id of the card
	 */
	private int				id;
	
	/**
	 * Tracks id number in between card creations
	 */
	private static int		idTracker	= 0;
	
	/**
	 * Makes a new card
	 * 
	 * @param par1
	 *            Name to be given to card
	 */
	public Card(String par1) {
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(new ZoomListener());
		setBackground(Color.GREEN);
		setSize(150, 225);
		name = par1;
		nameLabel.setText(par1);
		nameLabel.setFont(new Font("Times Roman", Font.BOLD, 9));
		nameLabel.setBounds(0, 0, getWidth(), 20);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameLabel);
		registerCard(this);
	}
	
	/**
	 * Gets the name of the card
	 * 
	 * @return Name string
	 * 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Registers card. Gives it an id number and adds to card array
	 * 
	 * @param par1
	 *            Card to be registered
	 */
	public void registerCard(Card par1) {
		boolean add = true;
		for (int i = 0; i < cardList.length; i++) {
			if (cardList[i] != null) {
				if (cardList[i].getName().equals(getName())) {
					add = false;
					break;
				} else {
					add = true;
				}
			} else {
				break;
			}
		}
		if (add) {
			id = idTracker;
			idTracker++;
			cardList[id] = this;
			System.out.println( getName() + " has been added to list at id " + id);
		}
	}
	
	/**
	 * Gets the id of the card
	 * 
	 * @return Int id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Zooms in the card by making it the height of the screen and blowing up
	 * all labels. Override for different card types
	 * 
	 * @param father
	 *            Card clicked on
	 */
	public void zoom(Card father) {
		JFrame frame = new JFrame();
		final JPanel card = new JPanel();
		card.setBorder(father.getBorder());
		card.setSize((int) (SwingUtilities.getWindowAncestor(father)
				.getHeight() / 1.5), SwingUtilities.getWindowAncestor(this)
				.getHeight());
		card.setLocation(0, 0);
		frame.setSize(card.getSize());
		frame.setLocation(
				(SwingUtilities.getWindowAncestor(father).getWidth() - card
						.getWidth()) / 2, 0);
		frame.setUndecorated(true);
		int multiplier = card.getWidth() / father.getWidth();
		JLabel nameLabel = new JLabel();
		Font nameFont = father.nameLabel.getFont();
		nameLabel.setText(((JLabel) getComponent(0)).getText());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font(nameFont.getFontName(), nameFont.getStyle(),
				nameFont.getSize() * multiplier));
		Rectangle name = new Rectangle(0, 0, father.nameLabel.getWidth()
				* multiplier, father.nameLabel.getHeight() * multiplier);
		nameLabel.setBounds(name);
		card.setLayout(null);
		card.setBackground(Color.GREEN);
		card.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Removing zoomed card");
				SwingUtilities.getWindowAncestor(card).dispose();
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
		card.add(nameLabel);
		frame.add(card);
		frame.setVisible(true);
	}
	
	/**
	 * Makes a copy of the card
	 * 
	 * @return The copied card
	 */
	public abstract Card copy();
}
