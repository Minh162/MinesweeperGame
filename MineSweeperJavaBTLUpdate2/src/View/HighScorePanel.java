package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import Control.Controller;
import Model.DataHolder;
import Model.GameData;

public class HighScorePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton menuButton;
	
	public Controller controller;
	
	public HighScorePanel(Controller cl) {
		// TODO Auto-generated constructor stub
		this.controller = cl;
		this.setLayout(new BorderLayout());
	}
	
	public void resetData() {
		this.removeAll();
		this.init();
	}
	
	public void init() {
		JLabel titleLabel = new JLabel("High Score");
		titleLabel.setPreferredSize(new Dimension(100, 100));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setFont(new Font("Arial", Font.BOLD, 30));
		JLabel levelLabel = new JLabel("Level");
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		levelLabel.setFont(new Font("Arial", Font.BOLD, 30));
		JLabel timeLabel = new JLabel("Time");
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		JPanel dataPanel = new JPanel(new GridLayout(4, 3));
		dataPanel.add(dateLabel);
		dataPanel.add(levelLabel);
		dataPanel.add(timeLabel);
		
		menuButton = new JButton("MENU");
		menuButton.setFont(new Font("Arial", Font.PLAIN, 30));
		menuButton.setPreferredSize(new Dimension(150, 50));
		menuButton.setFocusable(false);
		menuButton.setBackground(Color.white);
		
		JPanel menuButtonPanel = new JPanel();
		menuButtonPanel.setPreferredSize(new Dimension(100, 100));
		menuButtonPanel.add(menuButton);
		menuButton.addActionListener(controller);
		
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(dataPanel, BorderLayout.CENTER);
		this.add(menuButtonPanel, BorderLayout.SOUTH);
		
		//take data from sql
		ArrayList<DataHolder> listData = new ArrayList<DataHolder>();
		
		listData = GameData.getDataFromSQL();
		
		if(listData == null) {
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			DataHolder dh = listData.get(i);
			
			float time = dh.getTime();
			String date = dh.getDate();
			String level = dh.getLevel();
			
			date = date==null?"Not Won Yet" : date;
			JLabel label1 = new JLabel(date);
			label1.setHorizontalAlignment(JLabel.CENTER);
			label1.setFont(new Font("Arial", Font.PLAIN, 25));
			dataPanel.add(label1);
			
			JLabel label2 = new JLabel(level);
			label2.setHorizontalAlignment(JLabel.CENTER);
			label2.setFont(new Font("Arial", Font.PLAIN, 25));
			dataPanel.add(label2);
			
			String timeString = time==0?"Not Won Yet":String.format("%.2f", time);
			JLabel label3 = new JLabel(timeString);
			label3.setHorizontalAlignment(JLabel.CENTER);
			label3.setFont(new Font("Arial", Font.PLAIN, 25));
			dataPanel.add(label3);
		}
	}
}
