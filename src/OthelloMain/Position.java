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
		if (checkHorz(board[current])) {
			boolean sameColor = false;
			
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
	
	//If at least one piece flip && the move is not on an unplayable position
	public abstract boolean canPlay();
	
	


	
	
}
