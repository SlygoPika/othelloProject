package OthelloMain;

import java.util.Arrays;

public class UnplayablePosition extends Position {
	private static Position[] badPos;
	public final char UNPLAYABLE = '*';
	
	//Set the four center pos along the left column UNPLAYABLE
	public UnplayablePosition(Position pos) {
		super(badPos);
		badPos[16] = '*';
		badPos[24] = '*';
		badPos[32] = '*';
		badPos[40] = '*';
		canPlay();
		
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
