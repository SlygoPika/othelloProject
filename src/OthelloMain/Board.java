package OthelloMain;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Board {
	Position[] board = new Position[64];
	private Player first;
	private Player second;
	private Player current;
	private Position black;
	private Position white;
	
	
	//Constructor
	public Board(Player p1, Player p2) {
		super();
		this.first = p1;
		this.second = p2;
		current = p1;
		System.out.println("Name of p1 " + p1.getName());
		System.out.println("Name of p2 " + p2.getName());
		
		//Initialize the board
		//If the position can be play, it is a playable pos
		//If the position cannot be play, it is a unplayable pos
		
		drawBoard();
		play();
		inGameMenu();	
	}
	
	//Play() method that loops
	public void play() {
		for(int i = 0; i < 64; i++) {
			drawBoard();
			makeMove();
		}
			
	}
	
	//Method for current player to make their move
	//Only use this method when canPlay() returns true
	public void makeMove() {
		boolean hasMoved = false;
		//Scanner for user input
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("The position can be selected by adding the value of the row and col");
			System.out.println("Please make a move for " + current.getName() + " (0-63)");
			int move = sc.nextInt();
			if(move < 0 || move > 63) {
				System.out.println("Please make a move");
			} 
			//If canPlay != true, ask user to make a valid move
			else if (!(board[move].canPlay())){
				
				System.out.println("Please make a move on a valid position");
			} else {
				//Set the selected position to 'B'
				//Then switch current player from first to second, vice versa
				board[move] = black.getBlack();
				if(current == first) current=second;
				else current = first;
				hasMoved = true;
			}
		} while (!hasMoved);
		System.out.println("Called");
		
	}
	
	//Method to draw default 8x8 board
	private void drawBoard() {
		char[] axisX = {'0','1','2','3','4','5','6','7'};
		int[] axisY = {0,8,16,24,32,40,48,56};
		
		//Horizontal label
		for	(int i = 0; i < 8; i++) {
			System.out.print("\t");
			System.out.print(axisX[i]) ;
		}
		System.out.println();
		for(int row = 0; row < 8; row++) {
			//Vertical label
			System.out.print(axisY[row] + "\t");
			for(int col = 0; col < 8; col++) {
				System.out.print(board[row*8+col] + "\t");
			}
			System.out.println("\n");
		}
	}

	//In-game options
	public void inGameMenu()
    {
        String input;
        System.out.println("Choose one of these options");
        System.out.println("#######################################");
        System.out.println("#                                     #");
        System.out.println("# 1. Save                     	      #");
        System.out.println("# 2. Surrender                        #");
        System.out.println("# 3. Make move                        #");
        System.out.println("#                                     #");
        System.out.println("#######################################");
        Scanner menu = new Scanner(System.in);
        //Command to deal with in-game menu
    }
	
	//Method to save the board state 
	public Board(String save_file) {
		
		try	{
			//File will be created in the current folder
			File file = new File("savedGame");
			if (file.createNewFile())
				System.out.println("File Created: " + file.getName());
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
  
        try {
        	PrintWriter writer = new PrintWriter("savedGame.txt");
        	//Add first, second and current player as first 3 lines
    		writer.write(first.getName());
    		writer.write(second.getName());
            writer.write(current.getName());
            //Add state of board to String boardStr
            String boardStr ="";
            for(int i =0; i<board.length;i++) {
            	boardStr+=board[i];
            }
            writer.write(boardStr);
            writer.close();
		} catch (IOException e) {
			System.out.println("Failed to save game");
		}
	}
	
	//Method to load a board
	public static Board load() {
		File file = new File("savedGame.txt");
		Scanner sc;
		try {
			FileInputStream out = new FileInputStream(file);
			
			
		    
		    out.close();
		} catch (IOException e) {
		    System.out.println("Fail");
		}
		
		File file = new File("savedGame.txt");
		try {
			
			InputStreamReader fos = new InputStreamReader(file);
			BufferedReader bos = new BufferedReader(fos);
			
			
			Position[] board = new Position[64];
			while((board= dos.readLine())!= null) {
		    	System.out.print(board);
		    }
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
