package a10;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LightsOut extends JFrame implements ActionListener {
	private LightsButtons[][] buttons;
	private JButton quitButton;
	
	public LightsOut() {
		
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		buttons = new LightsButtons[5][5];
		
		//Grid panel
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(5, 5));
		for( int i = 0; i < 5; i++) {
			for( int c = 0; c < 5; c++) {
				buttons[i][c] = new LightsButtons(i, c);
				buttons[i][c].addActionListener(this);
				gridPanel.add(buttons[i][c]);
			}
			
		}
		JPanel quitPanel = new JPanel();
		quitButton = new JButton("quit");
		quitButton.addActionListener(this);
		quitPanel.add(quitButton);
		
		setTitle("LightsOut");
		setPreferredSize(new Dimension(500, 500));
		this.add(gridPanel, BorderLayout.CENTER);
		this.add(quitPanel, BorderLayout.NORTH);
		pack();
		
	}
	
	public void actionPerformed(ActionEvent e) {	

		
		
	}
	
	public static void main(String[] args) {
		LightsOut l = new LightsOut();
		l.setVisible(true);
	}
	
}
