package OthelloMain;

import java.util.Arrays;

public class PlayablePosition extends Position {
	
	public PlayablePosition() {
		super();
		canPlay();
	}

	//If the position is EMPTY, canPlay is true
	public boolean canPlay() {
		char piece = this.getPiece();
		if (piece == EMPTY) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		super.toString();
		return "" + super.getPiece();
	}
}
