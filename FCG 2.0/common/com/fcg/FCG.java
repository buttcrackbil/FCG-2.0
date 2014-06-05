package com.fcg;

import javax.swing.JFrame;

import com.fcg.labels.PictureLabel;
import com.fcg.panels.CardPanel;

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
	public static FCG		game;
	
	/**
	 * Quit label
	 */
	private PictureLabel	quit	= new PictureLabel("Quit");
	
	/**
	 * Quest label
	 */
	private PictureLabel	quest	= new PictureLabel("Quest");
	
	/**
	 * The panel everything is added to
	 */
	private CardPanel		panel	= new CardPanel();
	
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
		panel.repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}