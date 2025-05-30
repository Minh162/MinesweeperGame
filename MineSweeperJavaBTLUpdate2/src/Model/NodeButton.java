package Model;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import Control.Controller;

public class NodeButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nRow;
	private int nCol;
	private int value;
	
	private boolean isFlag = false;
	
	public NodeButton(int r, int c) {
		this.nRow = r;
		this.nCol = c;
		this.value = -1;
		this.setFont(new Font("Arial Black", Font.BOLD, 15));
		this.setForeground(Color.BLACK);
		this.setText("");
		this.setFocusable(false);
	}
	
	public void openNode() {
		if(this.value == 9) {
			this.setBackground(Color.red);
			this.setIcon(Controller.mineIcon);
		} else if(this.value == 0) {
			this.setText("");
			this.setBackground(Color.white);
		} else {
			this.setText(this.value+"");
			this.setBackground(Color.white);
		}
		this.setEnabled(false);
	}
	
	public void setIsFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
	
	public boolean isFlag() {
		return this.isFlag;
	}
	
	public boolean isMine() {
		return this.value == 9;
	}
	
	public int getnRow() {
		return nRow;
	}
	public void setnRow(int nRow) {
		this.nRow = nRow;
	}
	public int getnCol() {
		return nCol;
	}
	public void setnCol(int nCol) {
		this.nCol = nCol;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
