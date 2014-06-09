package com.fcg.panels;

import java.awt.Color;

import javax.swing.JPanel;

import com.fcg.FCG;
import com.fcg.card.playable.Armor;
import com.fcg.card.playable.Enemy;
import com.fcg.card.playable.Player;

/**
 * A panel that is used for battles
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class BattlePanel extends JPanel {
	
	public BattlePanel(Player player, Enemy enemy) {
		setBounds(0, 0, FCG.game.getWidth(), FCG.game.getHeight());
		setLayout(null);
		setBackground(Color.BLACK);
		player.setLocation(getWidth() - 200, getHeight() - 275);
		enemy.setLocation(50, 50);
		add(player);
		add(enemy);
		repaint();
	}
	
	public void attack(Player par1, Enemy par2) {
		if (par2.getEquippedArmor() == null) {
			par2.setHealth(par2.getHealth() - par1.getAttack());
		} else {
			par2.setHealth(par2.getHealth()
					- (par1.getAttack() - par2.getEquippedArmor().getArmor()));
		}
	}
	
	public void attack(Enemy par1, Player par2) {
		if (par2.getEquippedArmor() == null) {
			par2.setHealth(par2.getHealth() - par1.getAttack());
		} else {
			par2.setHealth(par2.getHealth()
					- (par1.getAttack() - par2.getEquippedArmor().getArmor()));
		}
	}
}
