package OthelloMain;

public class Board {
	private char[] board = new char[64];
	private static final char EMPTY = '.';
	private Player first;
	private Player second;
	private Player current;
	
	//Constructor
	public Board(Player p1, Player p2) {
		super();
		this.first = p1;
		this.second = p2;
		current = p1;
		System.out.println("Name of p1 " + p1.getName());
		System.out.println("Name of p2 " + p2.getName());
		
		//Fill board with EMPTY ASCII char
		for	(int i=0;i<board.length;i++) board[i]=EMPTY;
		drawBoard();
	}
	
	//Method for current player to make their move
	public void play() {
		
	}
	
	//Method to draw default 8x8 board
	private void drawBoard() {
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				System.out.print(board[row*8+col]);
			}
			System.out.println();
		}
	}

	//Method to save the board state 
	public Board(String save_file) {
		
	}
	
	//Method to load a board
	public static Board load() {
		
		return null;
	}


}
