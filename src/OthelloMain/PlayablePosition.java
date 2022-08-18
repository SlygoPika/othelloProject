package OthelloMain;


public class PlayablePosition extends Position {
	
	public PlayablePosition() {
		super.setPiece(EMPTY);
		super.toString();
	}

	public PlayablePosition(Player current) {
		Player p1 = new Player("Black");
		current.getName();
		if	(current==p1) {
			super.setPiece(BLACK);
			super.toString();
		}else {
			super.setPiece(WHITE);
			super.toString();
		}
		System.out.println("Black/White constructor called");
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
