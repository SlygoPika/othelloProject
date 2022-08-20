package OthelloMain;


public class PlayablePosition extends Position {
	
	public PlayablePosition() {
		super.setPiece(EMPTY);
		super.toString();
	}

	public PlayablePosition(Player current) {
		int p = current.getNum();
		if	(p==1) {
			super.setPiece(BLACK);
			super.toString();
		}else {
			super.setPiece(WHITE);
			super.toString();
		}
	}
	
	//If the position is EMPTY, canPlay is true
	public boolean canPlay() {
		char piece = this.getPiece();
		if (piece == EMPTY) {
			return true;
		}
		return false;
	}
	

}
