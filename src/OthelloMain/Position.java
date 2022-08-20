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
	//Flip method that changes the color of the current position
	public void flip(Player current) {
		
		// At this point current has already switched to another player
		int p = current.getNum();
		if	(p==1) {
			
			this.setPiece(WHITE);
			this.toString();
		}else {
			this.setPiece(BLACK);
			this.toString();
		}
	}
	
	
	//If at least one piece flip && the move is not on an unplayable position
	public abstract boolean canPlay();
	
	


	
	
}
