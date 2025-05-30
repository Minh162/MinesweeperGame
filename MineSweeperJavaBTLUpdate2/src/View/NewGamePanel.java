package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Control.Controller;

public class NewGamePanel extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;

	public int height = 9;
	public int width = 9;
	public int mines = 10;
	public int level = 1;
	
	public Controller controller;
	
	public ButtonGroup choseGroup;
	
	public JRadioButton easyButton;
	public JRadioButton mediumButton;
	public JRadioButton hardButton;
	public JRadioButton customButton;
	
	public JLabel titleLabel;
	public JLabel heightLabel;
	public JLabel widthLabel;
	public JLabel mineLabel;
	
	public JTextField heightTextField;
	public JTextField widthTextField;
	public JTextField mineTextField;
	
	public JButton startButton;
	
	public NewGamePanel(Controller controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.setLayout(new BorderLayout());
		init();
	}
	
	public void init() {
		choseGroup = new ButtonGroup();
		easyButton = new JRadioButton("Easy");
		easyButton.setFont(new Font("Arial", Font.PLAIN, 30));
		easyButton.setFocusable(false);
		easyButton.addActionListener(this);
		
		mediumButton = new JRadioButton("Medium");
		mediumButton.setFont(new Font("Arial", Font.PLAIN, 30));
		mediumButton.setFocusable(false);
		mediumButton.addActionListener(this);
		
		hardButton = new JRadioButton("Hard");
		hardButton.setFont(new Font("Arial", Font.PLAIN, 30));
		hardButton.setFocusable(false);
		hardButton.addActionListener(this);
		
		customButton = new JRadioButton("Custom");
		customButton.setFont(new Font("Arial", Font.PLAIN, 30));
		customButton.setFocusable(false);
		customButton.addActionListener(this);
		
		choseGroup.add(easyButton);
		choseGroup.add(mediumButton);
		choseGroup.add(hardButton);
		choseGroup.add(customButton);
		
		titleLabel = new JLabel("Chose Level");
		titleLabel.setPreferredSize(new Dimension(200, 200));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		JPanel levelsPanel = new JPanel();
		levelsPanel.setPreferredSize(new Dimension(100, 100));
		levelsPanel.add(easyButton);
		levelsPanel.add(mediumButton);
		levelsPanel.add(hardButton);
		levelsPanel.add(customButton);
		
		JPanel hwmPanel = new JPanel();
		
		heightLabel = new JLabel("Height: ");
		heightLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		widthLabel = new JLabel("Width: ");
		widthLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		mineLabel = new JLabel("Mine: ");
		mineLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		
		heightTextField = new JTextField();
		heightTextField.setHorizontalAlignment(JTextField.CENTER);
		heightTextField.setFont(new Font("Arial", Font.BOLD, 20));
		heightTextField.setPreferredSize(new Dimension(100, 30));
		heightTextField.setEditable(false);
		heightTextField.addKeyListener(this);
		
		widthTextField = new JTextField();
		widthTextField.setHorizontalAlignment(JTextField.CENTER);
		widthTextField.setFont(new Font("Arial", Font.BOLD, 20));
		widthTextField.setPreferredSize(new Dimension(100, 30));
		widthTextField.setEditable(false);
		widthTextField.addKeyListener(this);
		
		mineTextField = new JTextField();
		mineTextField.setHorizontalAlignment(JTextField.CENTER);
		mineTextField.setFont(new Font("Arial", Font.BOLD, 20));
		mineTextField.setPreferredSize(new Dimension(100, 30));
		mineTextField.setEditable(false);
		mineTextField.addKeyListener(this);
		
		hwmPanel.add(heightLabel);
		hwmPanel.add(heightTextField);
		hwmPanel.add(widthLabel);
		hwmPanel.add(widthTextField);
		hwmPanel.add(mineLabel);
		hwmPanel.add(mineTextField);
		
		
		JPanel startButtonPanel = new JPanel();
		startButton = new JButton("START");
		startButton.setPreferredSize(new Dimension(150, 50));
		startButton.setFocusable(false);
		startButton.setBackground(Color.white);
		startButton.setFont(new Font("Arial", Font.PLAIN, 30));
		startButton.addActionListener(controller);
		
		startButtonPanel.add(startButton);
		startButtonPanel.setPreferredSize(new Dimension(200, 100));
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(levelsPanel, BorderLayout.NORTH);
		mainPanel.add(hwmPanel, BorderLayout.CENTER);
		mainPanel.add(startButtonPanel, BorderLayout.SOUTH);
		
		
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(mainPanel, BorderLayout.CENTER);
	}
	
	public void setTextFieldsEditable(boolean isEditable) {
		heightTextField.setEditable(isEditable);
		widthTextField.setEditable(isEditable);
		mineTextField.setEditable(isEditable);
	}
	
	public void setTextForTextFields(String heightText, String widthText, String mineText) {
		heightTextField.setText(heightText);
		widthTextField.setText(widthText);
		mineTextField.setText(mineText);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.easyButton) {
			setTextFieldsEditable(false);
			setTextForTextFields("9", "9", "10");
		}
		
		if(e.getSource() == this.mediumButton) {
			setTextFieldsEditable(false);
			setTextForTextFields("16", "16", "40");
		}
		
		if(e.getSource() == this.hardButton) {
			setTextFieldsEditable(false);
			setTextForTextFields("16", "30", "99");
		}
		
		if(e.getSource() == this.customButton) {
			setTextForTextFields("", "", "");
			setTextFieldsEditable(true);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Kiem tra xem dau vao co phai 1 so > 0 hay khong
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
}
