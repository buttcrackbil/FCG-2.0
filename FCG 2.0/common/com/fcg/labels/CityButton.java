package com.fcg.labels;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Makes a label to be added to city gui
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class CityButton extends JLabel {
	
	/**
	 * Constructor for label
	 * 
	 * @param name
	 *            Displayed text
	 * @param listener
	 *            Listener for firing of label
	 */
	public CityButton(String name, MouseListener listener) {
		addMouseListener(listener);
		setOpaque(true);
		setBackground(Color.red);
		setSize(100, 100);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.BOTTOM);
		setText(name);
		setLayout(null);
	}
	
}
