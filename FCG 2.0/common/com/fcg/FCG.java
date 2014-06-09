package com.fcg;

import javax.swing.JFrame;

import com.fcg.card.playable.Armor;
import com.fcg.card.playable.Enemy;
import com.fcg.card.playable.Player;
import com.fcg.card.playable.Weapon;
import com.fcg.labels.PictureLabel;
import com.fcg.panels.BattlePanel;
import com.fcg.panels.CardPanel;
import com.fcg.quest.City;

/**
 * Game frame
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class FCG extends JFrame {
	
	/**
	 * Static game frame
	 */
	public static FCG			game;
	
	/**
	 * Quit label
	 */
	private PictureLabel		quit	= new PictureLabel("Quit");
	
	/**
	 * Quest label
	 */
	private PictureLabel		quest	= new PictureLabel("Single Player");
	
	/**
	 * The panel everything is added to
	 */
	public static CardPanel	panel	= new CardPanel();
	
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		System.out.println("Loading Fallout Card Game");
		game = new FCG();
	}
	
	/**
	 * Makes a new game frame
	 * 
	 */
	public FCG() {
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setTitle("Fallout Card Game");
		setLayout(null);
		setVisible(true);
		panel.setLayout(null);
		panel.setBounds(0, 0, getWidth(), getHeight());
		int parts = getHeight() / 5;
		quit.setBounds(0, panel.getHeight() - 100, 100, 100);
		quest.setBounds(getWidth() - 100, parts * 0, 100, 100);
		add(panel);
		panel.add(quit);
		panel.add(quest);
		// Player player = new Player("Player", "Description", 20, 5, 1);
		// player.equipArmor(new Armor("Armor", "Description", 2));
		// player.equipWeapon(Weapon.sniperChinese);
		// Enemy enemy = new Enemy("Enemy", "Description", 10, 5);
		// BattlePanel bp = new BattlePanel(player, enemy);
		// bp.setBounds(0, 0, getWidth(), getHeight());
		// add(bp);
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}