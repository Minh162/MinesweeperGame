package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GamePanel game;

	private ButtonPlay[][] arrayButton;

	public PanelPlayer(GamePanel game) {
		this.game = game;

		setLayout(new GridLayout(game.getW(), game.getH()));

		arrayButton = game.getWorld().getArrayButton();

		setBorder(BorderFactory.createLoweredBevelBorder());
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				add(arrayButton[i][j] = new ButtonPlay(this));
				arrayButton[i][j].addMouseListener(game);
			}
		}
	}

	public ButtonPlay[][] getArrayButton() {
		return arrayButton;
	}

	public void setArrayButton(ButtonPlay[][] arrayButton) {
		this.arrayButton = arrayButton;
	}

	public GamePanel getGame() {
		return game;
	}

	public void setGame(GamePanel game) {
		this.game = game;
	}

}
