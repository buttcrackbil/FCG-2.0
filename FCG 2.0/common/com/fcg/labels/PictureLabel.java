package com.fcg.labels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.fcg.listeners.LabelListener;

/**
 * Creates a clickable label with a picture as a background
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class PictureLabel extends JLabel {
	
	/**
	 * Creates a clickable label
	 * 
	 * @param text Text to be displayed
	 */
	public PictureLabel(String text) {
		setOpaque(true);
		setSize(100, 100);
		setBackground(Color.GREEN);
		setText(text);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.BOTTOM);
		addMouseListener(new LabelListener());
	}
}
