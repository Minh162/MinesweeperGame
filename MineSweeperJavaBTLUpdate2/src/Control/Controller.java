package Control;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.DataHolder;
import Model.Game;
import View.GameEndPanel;
import View.HighScorePanel;
import View.MenuBar;
import View.MenuPanel;
import View.NewGamePanel;
import View.PlayGamePanel;

public class Controller extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// List Panels
	public MenuPanel menuPanel;
	public NewGamePanel newGamePanel;
	public PlayGamePanel playGamePanel;
	public HighScorePanel highScorePanel;
	public GameEndPanel gameEndPanel;
	public MenuBar menuBar;
	
	// List Container
	public JPanel centerPanel;
	public JPanel mainPanel;
	public CardLayout cl;
	
	// Game Elems
	public Game g;
	public DataHolder gameData;
	
	// icons
	public static ImageIcon mineIcon = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\MineSweeperJavaBTLUpdate2\\src\\ImagesIcons\\mine.png");
	public static ImageIcon flagIcon = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\MineSweeperJavaBTLUpdate2\\src\\ImagesIcons\\flagicon.png");	
	public static ImageIcon smileIcon = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\MineSweeperJavaBTLUpdate2\\src\\ImagesIcons\\smileIcon.png");
	
	public Controller() {
		// set icon size
		Image img = mineIcon.getImage();
		img = img.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		mineIcon = new ImageIcon(img);
		
		img = flagIcon.getImage();
		img = img.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		flagIcon = new ImageIcon(img);
		
		img = smileIcon.getImage();
		img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		smileIcon = new ImageIcon(img);
		
		// TODO Auto-generated constructor stub
		this.setTitle("MineSweeper");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(mineIcon.getImage());
		init();
		this.setVisible(true);
	}
	
	// initiate layout and panels
	public void init() {
	    this.setLayout(new BorderLayout());
	    mainPanel = new JPanel(new BorderLayout());
	    centerPanel = new JPanel(new CardLayout());
	    
	    menuBar = new MenuBar(this);
	    menuPanel = new MenuPanel(this);
	    newGamePanel = new NewGamePanel(this);
	    playGamePanel = new PlayGamePanel(this);
	    highScorePanel = new HighScorePanel(this);
	    gameEndPanel = new GameEndPanel(this);
	    
	    
	    centerPanel.add(menuPanel, "menu");
	    centerPanel.add(newGamePanel, "newgame");
	    centerPanel.add(playGamePanel, "playgame");
	    centerPanel.add(highScorePanel, "scoreboard");
	    centerPanel.add(gameEndPanel, "endgame");
	    
	    cl = (CardLayout) centerPanel.getLayout();
	    
	    mainPanel.add(menuBar, BorderLayout.NORTH);
	    mainPanel.add(centerPanel, BorderLayout.CENTER);
	    
	    this.add(mainPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	// functions to switch between panels
	public void changeToMenuPanel() {
		this.setSize(700, 700);
		cl.show(centerPanel, "menu");
	}
	
	public void changeToNewGamePanel() {
		this.setSize(700, 700);
		cl.show(centerPanel, "newgame");
	}
	
	public void changeToHighScorePanel() {
		this.setSize(900, 700);
		highScorePanel.resetData();
		cl.show(centerPanel, "scoreboard");
	}
	
	public void changeToEndGamePanel() {
		this.setSize(700, 700);
		cl.show(centerPanel, "endgame");
		gameEndPanel.display();
	}
	
	public void changeToPlayGamePanel() {
		playGamePanel.removeAll();
		String heightText = newGamePanel.heightTextField.getText();
		String widthText = newGamePanel.widthTextField.getText();
		String minesText = newGamePanel.mineTextField.getText();
		
		if(heightText.equals("") || widthText.equals("") || minesText.equals("") ) {
			// hien ra bang canh bao o bi trong
			JOptionPane.showMessageDialog(
					this,
					"Height, width and mine should not be empty",
					"Notification",
					JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		int height = Integer.parseInt(heightText);
		int width = Integer.parseInt(widthText);
		int mines = Integer.parseInt(minesText);
		
		if(height > 100 || height == 0 || width == 0 || width > 100 ||  mines >= (height * width) || mines==0) {
			// hien ra bang canh bao cac thong so qua lon
			JOptionPane.showMessageDialog(
					this,
					"Height and Width should be greater than 0 and less than 100, "
					+ "Mine should gretaer than 0 and less than height*width value",
					"Notification",
					JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		// set size for frame by getting the max of 500 or max*buttonSize
		int buttonSize = 45;
		int max = Math.max(height, width);
		int maxSize = Math.max(500, max*buttonSize);
		this.setSize(maxSize, maxSize);
		
		g = new Game(height, width, mines);
		cl.show(centerPanel, "playgame");
		playGamePanel.resetTime();
		playGamePanel.displayGame();
	}
	
	
	// Action when click buttons in panels
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == menuBar.menuItem || e.getSource() == highScorePanel.menuButton || e.getSource() == gameEndPanel.menuButton) {
			changeToMenuPanel();
		} else if(e.getSource() == menuBar.newGameItem || e.getSource() == menuPanel.newGameButton) {
			changeToNewGamePanel();
		} else if(e.getSource() == menuBar.exitItem || e.getSource() == menuPanel.exitButton) {
			this.dispose();
		} else if(e.getSource() == menuPanel.scoreBoardButton) {
			changeToHighScorePanel();
		} else if(e.getSource() == newGamePanel.startButton || e.getSource() == gameEndPanel.playAgainButton) {
			if(!newGamePanel.easyButton.isSelected() && !newGamePanel.customButton.isSelected()
					&& !newGamePanel.mediumButton.isSelected() && !newGamePanel.hardButton.isSelected()) {
				return;
			}
			changeToPlayGamePanel();
		}
	}
}

