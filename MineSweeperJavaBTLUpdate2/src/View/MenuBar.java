package View;

import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Control.Controller;

public class MenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Controller controller;
	public JMenu loadMenu;
	public JMenu ruleMenu;
	
	public JMenuItem newGameItem;
	public JMenuItem exitItem;
	public JMenuItem menuItem;
	public JMenuItem ruleItem;
	
	public MenuBar(Controller controller) {
		// TODO Auto-generated constructor stub
		
		this.controller = controller;
		this.controller.setSize(700, 700);
		menuItem = new JMenuItem("Menu");
		menuItem.addActionListener(this.controller);
		newGameItem = new JMenuItem("New Game");
		newGameItem.addActionListener(this.controller);
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this.controller);

		ruleItem = new JMenuItem("<html><p style='width: 150px'>To win a game of Minesweeper, all non-mine cells must be opened without opening a mine. There is no score, however there is a timer recording the time taken to finish the game. Difficulty can be increased by adding mines or starting with a larger grid</p></html>");
		ruleItem.setPreferredSize(new Dimension(200, 150));
		
		loadMenu = new JMenu("Load");
		ruleMenu = new JMenu("Rule");
		
		loadMenu.add(menuItem);
		loadMenu.add(newGameItem);
		loadMenu.add(exitItem);
		ruleMenu.add(ruleItem);
		
		this.add(loadMenu);
		this.add(ruleMenu);
	}
	
}





