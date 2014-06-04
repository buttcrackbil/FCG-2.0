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
 * Weapon card
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class Weapon extends PlayableCard {
	
	/**
	 * Damage boost of card
	 */
	private int		damage;
	
	/**
	 * Label to display damage boost
	 */
	JLabel	damageLabel	= new JLabel();
	
	/**
	 * Creates a weapon card
	 * 
	 * @param par1
	 *            Name of the card
	 * @param par2
	 *            Description of the card
	 * @param par3
	 *            Damage increase from weapon
	 * @param par4
	 *            Cost of card
	 */
	public Weapon(String par1, String par2, int par3, SpendableCard... par4) {
		super(par1, par2, par4);
		damageLabel.setBounds(0, getHeight() - 20, 100, 20);
		setType(PlayableCard.WEAPON);
		setDamage(par3);
	}
	
	/**
	 * Sets the damage boost from weapon
	 * 
	 * @param par1
	 *            Damage to be added to creature when equipped
	 */
	public void setDamage(int par1) {
		damage = par1;
		damageLabel.setText("+" + par1);
		add(damageLabel);
		repaint();
	}
	
	/**
	 * Gets the damage boost from weapon
	 * 
	 * @return Damage that is added to creature when equipped
	 */
	public int getDamage() {
		return damage;
	}
	
	@Override
	public Weapon copy() {
		Weapon output = new Weapon(name, getDescription(), getDamage());
		return output;
	}
	
	@Override
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
		JLabel descriptionLabel = new JLabel();
		JLabel damageLabel = new JLabel();
		Font nameFont = father.nameLabel.getFont();
		Font descriptionFont = ((PlayableCard) father).descriptionLabel
				.getFont();
		Font damageFont = ((Weapon) father).damageLabel.getFont();
		nameLabel.setText(((JLabel) getComponent(0)).getText());
		descriptionLabel.setText(((JLabel) getComponent(1)).getText());
		damageLabel.setText(((JLabel) getComponent(2)).getText());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font(nameFont.getFontName(), nameFont.getStyle(),
				nameFont.getSize() * multiplier));
		descriptionLabel.setFont(new Font(descriptionFont.getFontName(),
				descriptionFont.getStyle(), descriptionFont.getSize()
						* multiplier));
		damageLabel.setFont(new Font(damageFont.getFontName(), damageFont
				.getStyle(), damageFont.getSize() * multiplier));
		Rectangle name = new Rectangle(0, 0, father.nameLabel.getWidth()
				* multiplier, father.nameLabel.getHeight() * multiplier);
		Rectangle description = new Rectangle(0,
				((PlayableCard) father).descriptionLabel.getLocation().y
						* multiplier,
				((PlayableCard) father).descriptionLabel.getWidth()
						* multiplier,
				((PlayableCard) father).descriptionLabel.getHeight()
						* multiplier);
		Rectangle damage = new Rectangle(0,
				((Weapon) father).damageLabel.getLocation().y * multiplier,
				((Weapon) father).damageLabel.getWidth() * multiplier,
				((Weapon) father).damageLabel.getHeight() * multiplier);
		nameLabel.setBounds(name);
		descriptionLabel.setBounds(description);
		damageLabel.setBounds(damage);
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
		card.add(damageLabel);
		frame.add(card);
		frame.setVisible(true);
	}
}
