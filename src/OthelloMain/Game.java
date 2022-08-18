package OthelloMain;

public class Game {
	
	public Game(Player p1, Player p2) {
		super();
		
	}
	
	public void start() {
		
	}
	
	public static void main(String[] args) {
		Player black = new Player("Black",1);
		Player white = new Player("White",2);
		Board board = new Board(black, white);
		board.makeMove();
		
	}
}
