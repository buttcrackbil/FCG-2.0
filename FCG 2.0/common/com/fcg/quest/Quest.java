package com.fcg.quest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fcg.labels.CityButton;
import com.fcg.panels.CardPanel;

/**
 * [WIP] Main class for questing system
 * 
 * @author Alex
 * 
 */
public class Quest {
	
	@SuppressWarnings("javadoc")
	public static Quest	operationAnchorage	= new Quest("Operation Anchorage",
													City.outcastOutpost);
	
	/**
	 * Sets all parts of a new quest
	 * 
	 * @param name
	 *            Name of quest
	 * @param start
	 *            City you must be in to start quest
	 * @param tasks
	 *            Tasks to be performed in quest
	 */
	public Quest(final String name, final City start, Task... tasks) {
		CityButton questLabel = new CityButton("[WIP] Op Anc", new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Started quest");
				confirm(start, name);
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
		start.addButton(questLabel);
	}
	
	/**
	 * Makes a confirm box
	 * 
	 * @param start
	 *            The city it is to be added to
	 * @param name
	 *            Name of the quest
	 */
	public void confirm(final City start, String name) {
		JButton no = new JButton("No");
		no.setSize(100, 20);
		JButton yes = new JButton("Yes");
		yes.setSize(100, 20);
		final JPanel confirm = new JPanel();
		confirm.setBackground(Color.YELLOW);
		confirm.setBounds((start.getWidth() - 200) / 2,
				(start.getHeight() - 150) / 2, 200, 150);
		confirm.setLayout(null);
		JLabel description = new JLabel("<html>Do you want to start " + name
				+ "?</html>");
		description
				.setBounds(0, 0, confirm.getWidth(), confirm.getHeight() / 2);
		no.setLocation(0, confirm.getHeight() - 20);
		yes.setLocation(confirm.getWidth() - 100, confirm.getHeight() - 20);
		confirm.add(description);
		confirm.add(no);
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.remove(confirm);
				start.repaint();
			}
			
		});
		confirm.add(yes);
		start.add(confirm);
		start.repaint();
	}
	
	/**
	 * Starts the questing system
	 * 
	 * @param par1
	 *            Card panel to add everything to
	 */
	public static void start(CardPanel par1) {
		System.out.println("Starting questing system");
		par1.removeAll();
		par1.add(City.outcastOutpost);
		par1.repaint();
	}
}
