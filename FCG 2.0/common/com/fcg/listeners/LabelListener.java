package com.fcg.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.fcg.labels.PictureLabel;
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
		PictureLabel label = (PictureLabel) arg0.getSource();
		
		switch(label.getText()){
			case "Quit" :
				System.exit(0);
				break;
			case "Quest" :
				Quest.start((CardPanel) label.getParent());
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
