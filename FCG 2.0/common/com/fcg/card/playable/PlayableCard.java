package com.fcg.card.playable;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.fcg.card.Card;
import com.fcg.card.spendable.SpendableCard;

/**
 * Main class for all enemy, weapon, armor, player, and companion cards
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public abstract class PlayableCard extends Card {
	
	/**
	 * Static int for quick referral to card type of {@link Enemy}
	 */
	protected static int	CREATURE			= 0;
	
	/**
	 * Static int for quick referral to card type of {@link Weapon}
	 */
	protected static int	WEAPON				= 1;
	
	/**
	 * Static int for quick referral to card type of {@link Armor}
	 */
	protected static int	ARMOR				= 2;
	
	/**
	 * Static int for quick referral to card type of {@link Player}
	 */
	protected static int	PLAYER				= 3;
	
	/**
	 * Extra strings to be added to name label. Dependent on the card type
	 */
	protected String[]		types				= { "(Creature)", "(Weapon)",
			"(Armor)", "(Player)"							};
	
	/**
	 * Displays description of card
	 */
	protected JLabel		descriptionLabel	= new JLabel();
	
	/**
	 * Array for cost of card
	 */
	private SpendableCard[]	cost;
	
	/**
	 * Booleans for getting card type see {@link #getType()}
	 */
	private boolean[]		b					= { false, false, false, false };
	
	/**
	 * Classes of all card types
	 */
	private Object[]		classes				= { Enemy.class, Weapon.class,
			Armor.class, Player.class			};
	
	/**
	 * Makes a card that is to be played (more permanent)
	 * 
	 * @param par1
	 *            Name of the card
	 * @param par2
	 *            Description of the card
	 * @param par3
	 *            Cost of the card
	 */
	public PlayableCard(String par1, String par2, SpendableCard... par3) {
		super(par1);
		descriptionLabel.setText("<html>" + par2 + "</html>");
		descriptionLabel.setBounds(0, (getHeight() - 100) / 2, getWidth(), 100);
		add(descriptionLabel);
		cost = par3;
	}
	
	/**
	 * Gets the card cost of card
	 * 
	 * @return SpendableCard array
	 */
	public SpendableCard[] getCost() {
		return cost;
	}
	
	/**
	 * Returns type of card
	 * 
	 * @param par1
	 *            Class of card
	 */
	protected void setType(int par1) {
		nameLabel.setText(types[par1] + " - " + getName());
		b[par1] = true;
		nameLabel.repaint();
	}
	
	/**
	 * Gets type of card
	 * 
	 * @return Class of card
	 */
	public Object getType() {
		Object output = null;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == true) {
				output = classes[i];
			}
		}
		return output;
	}
	
	/**
	 * Gets description of card
	 * 
	 * @return Description of card without html tags (to remove adding tags
	 *         twice)
	 */
	public String getDescription() {
		return descriptionLabel.getText().substring(6,
				descriptionLabel.getText().length() - 7);
	}
	
	/**
	 * Sets if the card is an Enemy
	 * 
	 * Use setType method
	 * 
	 * @param b
	 *            Set the enemy boolean to this
	 */
	@Deprecated
	protected void setEnemy(boolean b) {
		this.b[0] = b;
	}
	
	/**
	 * Sets if the card is a Weapon
	 * 
	 * Use setType method
	 * 
	 * @param b
	 *            Set the wepaon boolean to this
	 */
	@Deprecated
	protected void setWeapon(boolean b) {
		this.b[1] = b;
	}
	
	/**
	 * Gets if the card is an Enemy
	 * 
	 * Use getType method
	 * 
	 * @return True if card is an enemy
	 */
	@Deprecated
	protected boolean isEnemy() {
		return b[0];
	}
	
	/**
	 * Gets if the card is a Weapon
	 * 
	 * Use getType method
	 * 
	 * @return True if card is a weapon
	 */
	@Deprecated
	protected boolean isWeapon() {
		return b[1];
	}
	
	@Override
	public void zoom(final Card father) {
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
		JLabel descriptionLabel = new JLabel();
		Font nameFont = father.nameLabel.getFont();
		Font descriptionFont = ((PlayableCard) father).descriptionLabel
				.getFont();
		nameLabel.setText(((JLabel) getComponent(0)).getText());
		descriptionLabel.setText(((JLabel) getComponent(1)).getText());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font(nameFont.getFontName(), nameFont.getStyle(),
				nameFont.getSize() * multiplier));
		descriptionLabel.setFont(new Font(descriptionFont.getFontName(),
				descriptionFont.getStyle(), descriptionFont.getSize()
						* multiplier));
		Rectangle name = new Rectangle(0, 0, father.nameLabel.getWidth()
				* multiplier, father.nameLabel.getHeight() * multiplier);
		Rectangle description = new Rectangle(0,
				((PlayableCard) father).descriptionLabel.getLocation().y
						* multiplier,
				((PlayableCard) father).descriptionLabel.getWidth()
						* multiplier,
				((PlayableCard) father).descriptionLabel.getHeight()
						* multiplier);
		nameLabel.setBounds(name);
		descriptionLabel.setBounds(description);
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
		card.add(descriptionLabel);
		frame.add(card);
		frame.setVisible(true);
	}
	
	@Override
	public abstract Card copy();
}
