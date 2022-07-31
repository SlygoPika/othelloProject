package OthelloMain;

public class Game {
	
	public Game(Player p1, Player p2) {
		Player black = new Player("Black");
		Player white = new Player("White");
		Board board = new Board(black, white);
	}
	
	public void start() {
		
	}
	
	public static void main(String[] args) {
		Player black = new Player("Black");
		Player white = new Player("White");		
		Board board = new Board(black, white);
		
	}
}
