package OthelloMain;

public class PlayablePosition extends Position {
	public final char UNPLAYABLE = '*';
	
	public boolean canPlay() {
		return false;
	}
}
