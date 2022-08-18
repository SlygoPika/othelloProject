package OthelloMain;

public class UnplayablePosition extends Position {
	public final char UNPLAYABLE = '*';
	
	//Set the four center pos along the left column UNPLAYABLE
	public UnplayablePosition() {
		super.setPiece(UNPLAYABLE);
		super.toString();
	}


	
	@Override
	public String toString() {
		super.toString();
		return "" + super.getPiece();
	}

	//Check if the position contains the char '*'
	//Return false if '*' is in this position
	public boolean canPlay() {
		char piece = this.getPiece();
		if (piece == '*') {
			return false;
		}
		return true;
	}
	
}
