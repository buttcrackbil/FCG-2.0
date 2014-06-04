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
 * Armor card
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class Armor extends PlayableCard {
	
	/**
	 * Armor boost of card
	 */
	private int		armor;
	
	/**
	 * Label that displays armor boost
	 */
	JLabel	armorLabel	= new JLabel();
	
	/**
	 * Creates an armor card
	 * 
	 * @param par1 Name of the card
	 * @param par2 Description of the card
	 * @param par3 Armor boost
	 * @param par4 Cost of card
	 */
	public Armor(String par1, String par2, int par3, SpendableCard... par4) {
		super(par1, par2, par4);
		armorLabel.setBounds(0, getHeight() - 20, 100, 20);
		setType(PlayableCard.ARMOR);
		setArmor(par3);
	}
	
	/**
	 * Sets the armor boost
	 * 
	 * @param par1 Armor boost
	 */
	public void setArmor(int par1) {
		armor = par1;
		armorLabel.setText("+" + par1);
		add(armorLabel);
		repaint();
	}
	
	/**
	 * Gets the armor boost of card
	 * 
	 * @return Armor boost
	 */
	public int getArmor() {
		return armor;
	}
	
	@Override
	public Armor copy(){
		Armor output = new Armor(name, getDescription(), getArmor());
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
		JLabel armorLabel = new JLabel();
		Font nameFont = father.nameLabel.getFont();
		Font descriptionFont = ((PlayableCard) father).descriptionLabel
				.getFont();
		Font damageFont = ((Armor) father).armorLabel.getFont();
		nameLabel.setText(((JLabel) getComponent(0)).getText());
		descriptionLabel.setText(((JLabel) getComponent(1)).getText());
		armorLabel.setText(((JLabel) getComponent(2)).getText());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font(nameFont.getFontName(), nameFont.getStyle(),
				nameFont.getSize() * multiplier));
		descriptionLabel.setFont(new Font(descriptionFont.getFontName(),
				descriptionFont.getStyle(), descriptionFont.getSize()
						* multiplier));
		armorLabel.setFont(new Font(damageFont.getFontName(), damageFont
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
				((Armor) father).armorLabel.getLocation().y * multiplier,
				((Armor) father).armorLabel.getWidth() * multiplier,
				((Armor) father).armorLabel.getHeight() * multiplier);
		nameLabel.setBounds(name);
		descriptionLabel.setBounds(description);
		armorLabel.setBounds(damage);
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
		card.add(armorLabel);
		frame.add(card);
		frame.setVisible(true);
	}
}
