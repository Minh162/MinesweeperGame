package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.Controller;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Controller controller;
	
	public JPanel buttonsPanel;
	
	public JLabel welcomeLabel;
	
	public JButton newGameButton;
	public JButton scoreBoardButton;
	public JButton exitButton;
	
	
	public MenuPanel(Controller controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.setLayout(new BorderLayout());
		this.init();
	}
	
	public void init() {
		buttonsPanel = new JPanel();
		
		welcomeLabel = new JLabel("WELCOME TO MINESWEEPER");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
		welcomeLabel.setPreferredSize(new Dimension(400, 400));
		
		newGameButton = new JButton("New Game");
		newGameButton.setPreferredSize(new Dimension(150, 50));
		newGameButton.setFocusable(false);
		newGameButton.setFont(new Font("Arial", Font.BOLD, 15));
		newGameButton.setBackground(Color.white);
		newGameButton.addActionListener(controller);
		
		scoreBoardButton = new JButton("Score Board");
		scoreBoardButton.setPreferredSize(new Dimension(150, 50));
		scoreBoardButton.setFocusable(false);
		scoreBoardButton.setFont(new Font("Arial", Font.BOLD, 15));
		scoreBoardButton.setBackground(Color.white);
		scoreBoardButton.addActionListener(controller);
		
		exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(150, 50));
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Arial", Font.BOLD, 15));
		exitButton.setBackground(Color.white);
		exitButton.addActionListener(controller);
		
		buttonsPanel.add(newGameButton);
		buttonsPanel.add(scoreBoardButton);
		buttonsPanel.add(exitButton);
		
		this.add(welcomeLabel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
}
