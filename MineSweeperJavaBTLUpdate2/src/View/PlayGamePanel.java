package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Control.Controller;
import Model.DataHolder;
import Model.Game;
import Model.GameData;
import Model.NodeButton;

public class PlayGamePanel extends JPanel implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// display
	int height;
	int width;
	
	// game elem
	NodeButton[][] gameButton;
	Controller controller;

	// timer
	JLabel timeCheckLabel;
	public Timer time;
	private float currentTime;
	boolean isTimeStart;
	
	// flag count
	JLabel flagCheckLabel;
	int currentFlag;
	
	// play again
	JButton playAgainLevelButton;
	
	// panels
	JPanel gamePanel;
	
	public void resetTime() {
		currentTime = 0;
		if(isTimeStart==true) {
			time.stop();
			isTimeStart = false;
		}
		time = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentTime += 0.1;
				updateTimeCheckLabel();
			}
		});
	}
	
	// update thoi gian theo timer
	public void updateTimeCheckLabel() {
		timeCheckLabel.setText("Time: " + String.format("%.1f", currentTime));
	}
	
	// make new game with same level
	public void makeNewGame() {
		controller.g = new Game(height, width, controller.g.getNumberOfMines());
		resetTime();
		displayGame();
	}
	
	public void displayGame() {
		// reset mouse listener
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				gameButton[i][j].removeMouseListener(this);
			}
		}
		
		this.removeAll();
		this.currentFlag = controller.g.getNumberOfFlags();
		
		// set height and width
		this.height = controller.g.getHeight();
		this.width = controller.g.getWidth();
		
		// display game
		this.init();
		controller.setVisible(true);
	}
	
	public PlayGamePanel(Controller controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.setLayout(new BorderLayout());
	}
	
	public void init() {
		flagCheckLabel = new JLabel("Flag: " + currentFlag);
		flagCheckLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		flagCheckLabel.setHorizontalAlignment(JLabel.CENTER);
		flagCheckLabel.setPreferredSize(new Dimension(150, 50));
		
		timeCheckLabel = new JLabel("Time: " + currentTime);
		timeCheckLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		timeCheckLabel.setHorizontalAlignment(JLabel.CENTER);
		timeCheckLabel.setPreferredSize(new Dimension(150, 50));
		
		playAgainLevelButton = new JButton();
		playAgainLevelButton.setIcon(Controller.smileIcon);
		playAgainLevelButton.setBackground(Color.white);
		playAgainLevelButton.setFocusable(false);
		playAgainLevelButton.addActionListener(this);
		
		JPanel centerTopPanel = new JPanel();
		centerTopPanel.add(playAgainLevelButton);
		
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(flagCheckLabel, BorderLayout.WEST);
		topPanel.add(timeCheckLabel, BorderLayout.EAST);
		topPanel.add(centerTopPanel, BorderLayout.CENTER);
		
		gamePanel = new JPanel(new GridLayout(height, width));
		gameButton = controller.g.getGame();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				gameButton[i][j].addMouseListener(this);	
				gamePanel.add(gameButton[i][j]);
			}
		}
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);
	}
	
	// flag/unflag the grid
	public void setFlag(NodeButton nb) {
		if(!nb.isEnabled()) {
			return;
		}
		if(!nb.isFlag()) {
			if(currentFlag == 0) {
				return;
			}
			nb.setIsFlag(true);;
			nb.setIcon(Controller.flagIcon);
			currentFlag -= 1;
		} else if(nb.isFlag()) {
			nb.setIsFlag(false);
			nb.setIcon(null);
			currentFlag += 1;
		}
		this.flagCheckLabel.setText("Flag: " + currentFlag);	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// quay lai neu het game
		if(controller.g.isEnd()) {
			return;
		}
		
		if(e.getSource() instanceof NodeButton) {
			NodeButton nb = (NodeButton) e.getSource();
			
			// chuot phai set flag cho grid
			if(e.getButton() == MouseEvent.BUTTON3) {
				if(!isTimeStart) {
					return;
				}
				setFlag(nb);
			}
			
			// neu ma node isFlag thi khong lam gi ca
			if(nb.isFlag()) {
				return;
			}
			
			// xu ly khi click chuot trai
			if(e.getButton() == MouseEvent.BUTTON1) {
				// Bat dau tinh gio
				if(!isTimeStart) {
					isTimeStart = true;
					time.start();
				}
				
				// Kiem tra va set firstNode de tranh truong hop 
				// thua ngay tu lan click dau tien
				if(controller.g.firstNode == null) {
					controller.g.firstNode = nb;
					controller.g.newGame();
					this.displayGame();
				}
				
				// reveal node
				controller.g.reveal(nb.getnRow(), nb.getnCol());
				
				// neu ma thua thi hien cac lua chon
				if(controller.g.isLost()) {
					time.stop();
					int option = JOptionPane.showConfirmDialog(this, "You lost, play again?", "Notification",
							JOptionPane.YES_NO_OPTION);

					if (option == JOptionPane.YES_OPTION) {
						makeNewGame();
					} else {
						controller.changeToMenuPanel();
					}	
					return;
				}
				
				
				// neu ma thang thi luu lai du lieu choi va chuyen den endGamePanel
				if(controller.g.isEnd()) {
					time.stop();
					// display option panel
					SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
			        Date currentDate = new Date();
			        String dateFinished = dateFormat.format(currentDate);
			        String level = controller.g.getLevel();
			        controller.gameData = new DataHolder(dateFinished, currentTime, level);
			        GameData.saveDataToSQL(controller.gameData);
					controller.changeToEndGamePanel();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Tao mot game moi cung level khi click vao mat cuoi :))
		if(e.getSource() == playAgainLevelButton) {
			makeNewGame();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}
}
