package OthelloMain;

public class Game {
	
	public Game(Player p1, Player p2) {
		super();
		Board board = new Board(p1, p2);
	}
	
	public void start() {
		
	}
	
	public static void main(String[] args) {
		Player black = new Player("Black",1);
		Player white = new Player("White",2);
		Game newGame = new Game(black,white);
		
	}

}
