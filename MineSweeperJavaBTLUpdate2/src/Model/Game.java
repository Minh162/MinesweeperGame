package Model;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	private String level;
	private int height;
	private int width;
	private int numberOfMines;
	private int numberOfFlags;
	private boolean isEnd = false;
	private boolean isLost = false;
	public NodeButton firstNode;
	
	private NodeButton[][] game;
	private ArrayList<NodeButton> listMines;
	
	public Game(int height, int width, int mines){
		this.height = height;
		this.width = width;
		this.numberOfMines = mines;
		this.numberOfFlags = mines; 
		setLevel();
		game = new NodeButton[height][width];
		makeListNode();
		
	}
	
	private void setLevel() {
		if(this.height == 9 && this.width == 9 && this.numberOfMines == 10) {
			this.level = "Easy";
		} else if(this.height == 16 && this.width == 16 && this.numberOfMines == 40) {
			this.level = "Medium";
		} else if(this.height == 16 && this.width == 30 && this.numberOfMines == 99) {
			this.level = "Hard";
		} else {
			this.level = "Custom";
		}
	}
	
	public String getLevel() {
		return this.level;
	}
	
	public int getNumberOfFlags() {
		return numberOfFlags;
	}

	public void setNumberOfFlags(int numberOfFlags) {
		this.numberOfFlags = numberOfFlags;
	}

	public int getNumberOfMines() {
		return this.numberOfMines;
	}
	
	public void newGame() {
		makeListMines();
		makeListNode();
		reveal(firstNode.getnRow(), firstNode.getnCol());
		
		System.out.println("-----------------");
		for (NodeButton[] nodeButtons : game) {
			for (NodeButton nodeButton : nodeButtons) {
				System.out.print(nodeButton.getValue() + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
	// check xem mine da ton tai o vi tri (row, column) chua
	public boolean isMinesAlreadyInitialize(int row, int column) {
		for(NodeButton mine: listMines) {
			if(mine.getnRow() == row && mine.getnCol() == column) {
				return true;
			}
		}
		return false;
	}
	
	// tao ngau nhien cac mines va add vao listMines
	public void makeListMines() {
		listMines = new ArrayList<NodeButton>();
		Random rd = new Random();
		for(int i = 0; i < numberOfMines; i++) {
			int r;
			int c;
			do {
				r = rd.nextInt(this.height);
				c = rd.nextInt(this.width);
			} while(isMinesAlreadyInitialize(r, c) || (r==firstNode.getnRow()&&c==firstNode.getnCol()));
			NodeButton mine = new NodeButton(r, c);
			mine.setValue(9);
			listMines.add(mine);
			game[r][c] = mine;
		}
	}
	
	// khoi tao gia tri cac node theo vi tri cua cac mines 
	public void makeListNode() {
		// khoi tao node dua tren vi tri
		for(int i = 0; i < this.height; i++) {
			for(int j = 0; j < this.width; j++) {
				if(game[i][j] != null) {
					continue;
				}
				NodeButton n = new NodeButton(i, j);
				game[i][j] = n;
			}
		}
		
		// khoi tao gia tri cho cac node
		for(int i=0; i < this.height; i++) {
			for(int j=0; j < this.width; j++) {
				NodeButton currentNode = game[i][j];
				if(currentNode.isMine()) {
					continue;
				}
				int nodeValue = getValueForNode(currentNode);
				currentNode.setValue(nodeValue);
			}
		}
	}
	
	
	// tinh toan gia tri cac node dua theo so mines xung quanh
	public int getValueForNode(NodeButton n) {
		int startRow = n.getnRow()-1;
		int startColumn = n.getnCol()-1;
		int value = 0;
		for(int i = startRow; i < startRow+3; i++) {
			for(int j = startColumn; j < startColumn+3; j++) {
				if(i < 0 || i >= this.height || j < 0 || j >= this.width) {
					continue;
				}
				NodeButton checkNode = game[i][j];
				if(checkNode.isMine()) {
					value++;
				}
			}
		}
		return value;
	}
	
	// khi click vao node thi goi ham reveal
	public void reveal(int row, int col) {
		// Neu ma thua game thi khong lam gi
		if(isLost) {
			return;
		}
		
		// Neu ma vi tri khong hop le thi khong lam gi
		if (row < 0 || row >= this.height || col < 0 || col >= this.width) {
	        return;
	    }
		
	    NodeButton currentButton = game[row][col];
	    
	    // Neu node ma da duoc mo hoac bi cam co thi khong lam gi
	    if(!currentButton.isEnabled() || currentButton.isFlag()) {
	    	return;
	    }
	    
	    // Neu node la mine thi thua
	   	if(currentButton.isMine()) {
	   		for (NodeButton mine : listMines) {
				mine.openNode();
			}
	    	this.isEnd = true;
	    	this.isLost = true;
	   		return;
	   	}
	   
	   	
	    if(currentButton.getValue() > 0) {
	    	// Neu ma gia tri cua Node khac 0 thi chi mo node
	    	currentButton.openNode();
	    	checkIsEnd();
	    	
	    } else {
	    	// Neu gia tri cua node = 0 thi check xem con node = 0 nao
	    	// xung quanh hay khong neu co thi mo no ra
	    	currentButton.openNode();
	    	
	    	// flood fill algorithm
	    	reveal(row-1, col);
	    	reveal(row+1, col);
	    	reveal(row, col+1);
	    	reveal(row, col-1);

	    	checkIsEnd();
	    }
	}
	
	// kiem tra xem da thua chua va luu vao isEnd
	public void checkIsEnd() {
		int numberOfNodes = width * height - listMines.size();
		
		int numberOfOpenNodes = 0;
		
		for (NodeButton[] nodeButtons : game) {
			for (NodeButton nodeButton : nodeButtons) {
				if(nodeButton.isMine()) {
					continue;
				}
				if(!nodeButton.isEnabled()) {
					numberOfOpenNodes++;
				}
			}
		}
		
		isEnd = (numberOfOpenNodes == numberOfNodes);
	}
	
	// kiem tra neu ket thuc
	public boolean isEnd() {
		return this.isEnd;
	}
	
	// kiem tra neu thua
	public boolean isLost() {
		return this.isLost;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public NodeButton[][] getGame() {
		return game;
	}

	public void setGame(NodeButton[][] game) {
		this.game = game;
	}
}
