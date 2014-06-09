package com.fcg.card.playable;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
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
 * Card for all non-player and non-companion cards
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class Enemy extends PlayableCard {
	
	/**
	 * Health of card
	 */
	private int		health;
	
	/**
	 * Attack of card
	 */
	private int		attack;
	
	/**
	 * Label that displays health
	 */
	private JLabel	healthLabel		= new JLabel();
	
	/**
	 * Label that displays attack
	 */
	private JLabel	attackLabel		= new JLabel();
	
	/**
	 * Keeps track of all equipped cards
	 */
	private int		equippedCards	= 1;
	
	/**
	 * Keeps track of equipped weapon
	 */
	private Weapon	equippedWeapon;
	
	/**
	 * Keeps track of equipped armor
	 */
	private Armor	equippedArmor;
	
	/**
	 * Keeps track of original location of equipped weapon
	 */
	private Point	weaponLocation;
	
	/**
	 * Keeps track of original location of equipped armor
	 */
	private Point	armorLocation;
	
	/**
	 * Makes a creature card
	 * 
	 * @param par1
	 *            Name
	 * @param par2
	 *            Description
	 * @param par3
	 *            Health
	 * @param par4
	 *            Attack
	 * @param par5
	 *            Cost of card
	 */
	public Enemy(String par1, String par2, int par3, int par4,
			SpendableCard... par5) {
		super(par1, par2, par5);
		health = par3;
		attack = par4;
		setType(PlayableCard.CREATURE);
		add(descriptionLabel);
		healthLabel.setText("Health: " + health);
		attackLabel.setText("Attack: " + attack);
		healthLabel.setBounds(0, getHeight() - 40, getWidth(), 20);
		attackLabel.setBounds(0, getHeight() - 20, getWidth(), 20);
		add(healthLabel);
		add(attackLabel);
	}
	
	/**
	 * Sets health of card
	 * 
	 * @param i
	 */
	public void setHealth(int i){
		health = i;
		refreshHealthLabel();
	}
	
	/**
	 * Gets the health of the card
	 * 
	 * @return Card's current health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Gets the attack of the card
	 * 
	 * @return Card's current attack
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Equips a weapon to the card
	 * 
	 * @param par1
	 *            Weapon to be added to card
	 */
	public void equipWeapon(Weapon par1) {
		weaponLocation = par1.getLocation();
		par1.setLocation(getLocation().x, getLocation().y
				- (25 * equippedCards));
		attackLabel.setText(attackLabel.getText() + " "
				+ par1.damageLabel.getText());
		repaint();
		attack += par1.getDamage();
		equippedWeapon = par1;
		equippedCards++;
	}
	
	/**
	 * Equips armor to the card
	 * 
	 * @param par1
	 *            Armor to be added to card
	 */
	public void equipArmor(Armor par1) {
		armorLocation = par1.getLocation();
		par1.setLocation(getLocation().x, getLocation().y
				- (25 * equippedCards));
		healthLabel.setText(healthLabel.getText() + " "
				+ par1.armorLabel.getText());
		repaint();
		health += par1.getArmor();
		equippedArmor = par1;
		equippedCards++;
	}
	
	/**
	 * @return Equipped weapon (null if none is equipped)
	 */
	public Armor getEquippedArmor(){
		return equippedArmor;
	}
	
	/**
	 * Removes weapon from card
	 */
	public void dequipWeapon() {
		attackLabel.setText(attackLabel.getText().substring(
				0,
				attackLabel.getText().length()
						- (equippedWeapon.damageLabel.getText().length() + 1)));
		equippedWeapon.setLocation(weaponLocation);
		equippedWeapon = null;
		if (equippedCards >= 3) {
			equippedCards -= 2;
		}
		if (equippedArmor != null) {
			equippedArmor.setLocation(getLocation().x, getLocation().y
					- (25 * equippedCards));
		}
		System.out.println(equippedCards);
	}
	
	/**
	 * Removes armor from card
	 */
	public void dequipArmor() {
		healthLabel.setText(healthLabel.getText().substring(
				0,
				(healthLabel.getText().length() - equippedArmor.armorLabel
						.getText().length()) + 1));
		equippedArmor.setLocation(armorLocation);
		equippedArmor = null;
		if (equippedCards >= 3) {
			equippedCards -= 2;
		}
		if (equippedWeapon != null) {
			equippedWeapon.setLocation(getLocation().x, getLocation().y
					- (25 * equippedCards));
		}
	}
	
	public void refreshHealthLabel(){
		healthLabel.setText("Health: " + health);
		healthLabel.repaint();
	}
	
	@Override
	public Enemy copy() {
		Enemy output = new Enemy(name, getDescription(), getHealth(),
				getAttack());
		return output;
	}
	
	@Override
	public void zoom(final Card father) {
		JFrame frame = new JFrame();
		final JPanel card = new JPanel();
		card.setBorder(father.getBorder());
		card.setSize((int) (SwingUtilities.getWindowAncestor(father)
				.getHeight() / 1.5), SwingUtilities.getWindowAncestor(father)
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
		JLabel healthLabel = new JLabel();
		JLabel attackLabel = new JLabel();
		Font nameFont = father.nameLabel.getFont();
		Font descriptionFont = ((PlayableCard) father).descriptionLabel
				.getFont();
		Font healthFont = ((Enemy) father).healthLabel.getFont();
		Font attackFont = ((Enemy) father).attackLabel.getFont();
		nameLabel.setText(((JLabel) getComponent(0)).getText());
		descriptionLabel.setText(((JLabel) getComponent(1)).getText());
		healthLabel.setText(((JLabel) getComponent(2)).getText());
		attackLabel.setText(((JLabel) getComponent(3)).getText());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font(nameFont.getFontName(), nameFont.getStyle(),
				nameFont.getSize() * multiplier));
		descriptionLabel.setFont(new Font(descriptionFont.getFontName(),
				descriptionFont.getStyle(), descriptionFont.getSize()
						* multiplier));
		healthLabel.setFont(new Font(healthFont.getFontName(), healthFont
				.getStyle(), healthFont.getSize() * multiplier));
		attackLabel.setFont(new Font(attackFont.getFontName(), attackFont
				.getStyle(), attackFont.getSize() * multiplier));
		Rectangle name = new Rectangle(0, 0, father.nameLabel.getWidth()
				* multiplier, father.nameLabel.getHeight() * multiplier);
		Rectangle description = new Rectangle(0,
				((PlayableCard) father).descriptionLabel.getLocation().y
						* multiplier,
				((PlayableCard) father).descriptionLabel.getWidth()
						* multiplier,
				((PlayableCard) father).descriptionLabel.getHeight()
						* multiplier);
		Rectangle health = new Rectangle(0,
				((Enemy) father).healthLabel.getLocation().y * multiplier,
				((Enemy) father).healthLabel.getWidth() * multiplier,
				((Enemy) father).healthLabel.getHeight() * multiplier);
		Rectangle attack = new Rectangle(0,
				((Enemy) father).attackLabel.getLocation().y * multiplier,
				((Enemy) father).attackLabel.getWidth() * multiplier,
				((Enemy) father).attackLabel.getHeight() * multiplier);
		nameLabel.setBounds(name);
		descriptionLabel.setBounds(description);
		healthLabel.setBounds(health);
		attackLabel.setBounds(attack);
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
		card.add(healthLabel);
		card.add(attackLabel);
		frame.add(card);
		frame.setVisible(true);
	}
}