package OthelloMain;
public abstract class Position {
	private char piece;
	public static final char EMPTY = '.';
	public static final char BLACK = 'B';
	public static final char WHITE = 'W';
	
	//Setters and getters
	public static char getEmpty() {
		return EMPTY;
	}
	public static char getBlack() {
		return BLACK;
	}
	public static char getWhite() {
		return WHITE;
	}
	public char getPiece() {
		return piece;
	}
	public void setPiece(char piece) {
		this.piece = piece;
	}
	

	//Take an array of Positions and initialize them
	public Position() {
		super();
		
	}
	
	//Make an array of position objects and make a toString method 
	//that returns an empty string 
	//+ piece which is of type char
	public String toString() {
		return "" + piece;
	}
	
	//Flip method that determine which pieces were converted
	public void flip() {
		//Check if there is a valid horizontal line
		if () {
			
			//Loop until the same color is found in the horizontal line
			//Has to work for both direction
			//Has to stay within the row
			//Once found the same color, set every element in the array to current color.
		}
		
		//Check if there is a valid vertical line
		if (checkVert(board[current])) {
			//Loop until the same color is found in the vertical line
			//Has to work for both direction
			//Has to stay within the column
			//Once found the same color, set every element in the array to current color.
			
		}
		
		//Check if there is a valid diagonal line
		if (checkDiag(board[current])) {
			//Loop until the same color is found in the diagonal line
			//Has to work for both direction
			//Has to stay within the board
			//Once found the same color, set every element in the array to current color.
		}
	}
	
	public boolean check(int current) {
		//Check the 8 positions around the current position
		//Need to catch exception when array goes out of bound.
		if	(board[current]!= EMPTY) {
			
			if	(board[current+1] != EMPTY &&
				 board[current+1] == board[current]
				){return true;}
			//May be try implementing recursion here
			if	(board[current-1] != EMPTY &&
					 board[current-1] == board[current]
					){return true;}
			
			//Check vertical
			if	(board[current+8] != EMPTY &&
					 board[current+8] == board[current]
					){return true;}
			if	(board[current-8] != EMPTY &&
					 board[current-8] == board[current]
					){return true;}
			
			//Check diagonal
			if	(board[current+7] != EMPTY &&
					 board[current+7] == board[current]
					){return true;}
			if	(board[current+9] != EMPTY &&
					 board[current+9] == board[current]
					){return true;}
			if	(board[current-7] != EMPTY &&
					 board[current-7] == board[current]
					){return true;}
			if	(board[current-9] != EMPTY &&
					 board[current-9] == board[current]
					){return true;}
		}
		return false;
	}
	//If at least one piece flip && the move is not on an unplayable position
	public abstract boolean canPlay();
	
	


	
	
}
