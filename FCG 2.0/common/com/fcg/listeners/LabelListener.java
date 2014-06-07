package com.fcg.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.fcg.panels.CardPanel;
import com.fcg.quest.Quest;

/**
 * 
 * 
 * @author Alex
 *
 */
public class LabelListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel label = (JLabel) arg0.getSource();
		
		switch(label.getText()){
			case "Quit" :
				System.exit(0);
				break;
			case "Single Player" :
				Quest.start((CardPanel) label.getParent());
				break;
			default:
				System.out.println(label.getText() + " is not registered");
				break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
