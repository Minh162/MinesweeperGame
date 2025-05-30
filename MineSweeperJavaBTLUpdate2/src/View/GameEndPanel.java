package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.Controller;

public class GameEndPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Controller controller;
	public JButton playAgainButton;
	public JButton menuButton;

	public GameEndPanel(Controller controller) {
		this.controller = controller;
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
	}
	
	
	public void display() {
		this.removeAll();
		this.init();
	}
	
	public void init() {
		if(controller.gameData == null) {
			return;
		}
		
		JLabel titleLabel = new JLabel("CONGRATULATION");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		titleLabel.setPreferredSize(new Dimension(150, 150));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel dataPanel = new JPanel(new GridLayout(3, 1));
		JLabel levelLabel = new JLabel("Level: " + controller.gameData.getLevel());
		levelLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel timeLabel = new JLabel("Time: " + String.format("%.2f", controller.gameData.getTime()));
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel dateLabel = new JLabel("Date: " + controller.gameData.getDate());
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		
		dataPanel.add(levelLabel);
		dataPanel.add(timeLabel);
		dataPanel.add(dateLabel);
		
		JPanel bottomPanel = new JPanel();
		
		menuButton = new JButton("Menu");
		menuButton.setFont(new Font("Arial", Font.PLAIN, 20));
		menuButton.setPreferredSize(new Dimension(150, 50));
		menuButton.setBackground(Color.white);
		menuButton.setFocusable(false);
		menuButton.addActionListener(controller);
		
		playAgainButton = new JButton("Play Again");
		playAgainButton.setFont(new Font("Arial", Font.PLAIN, 20));
		playAgainButton.setPreferredSize(new Dimension(150, 50));
		playAgainButton.setFocusable(false);
		playAgainButton.setBackground(Color.white);
		playAgainButton.addActionListener(controller);
		
		bottomPanel.add(menuButton);
		bottomPanel.add(playAgainButton);
		bottomPanel.setPreferredSize(new Dimension(150, 150));
		
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(dataPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}
	
}
