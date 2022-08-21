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
import java.util.Arrays;
import java.util.Scanner;

public class Board {
	Position[] board = new Position[64];
	private Player first;
	private Player second;
	private Player current;
	
	
	//Constructor
	public Board(Player p1, Player p2) {
		super();
		this.first = p1;
		this.second = p2;
		current = p1;
		
		//Initialize the board
		for(int i =0; i<board.length;i++) {
			board[i] = new PlayablePosition();
			//Initial starting positions
			board[27] = new PlayablePosition(second);
			board[28] = new PlayablePosition(first);
			board[35] = new PlayablePosition(first);
			board[36] = new PlayablePosition(second);
		}
		drawBoard();
		play();
//		inGameMenu();	
	}
	
	//Play() method that loops
	public void play() {
		for(int i = 0; i < 64; i++) {
			makeMove();
		}
			
	}
	
	//Method for current player to make their move
	//Only use this method when canPlay() returns true
	public void makeMove() {
		boolean hasMoved = false;
		int move = 0;
		//Scanner for user input
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("The position can be selected by adding the value of the row and col");
			System.out.println("Please make a move for " + current.getName() + " (0-63)");
			move = sc.nextInt();
			if(move < 0 || move > 63) {
				System.out.println("Please make a move");
			} 
			//If canPlay != true, ask user to make a valid move
			else if (!(board[move].canPlay())){
				System.out.println("Please make a move on a valid position");
				drawBoard();
			} else {
				//Set the selected position to 'B'
				//Then switch current player from first to second, vice versa
				board[move] = new PlayablePosition(current);
				
				hasMoved = true;
				//If checkFlip() returns false, the move is invalid
				if	(checkRight(move,move)) 	{rightFlip(move,move,current);}
				if	(checkLeft(move,move))		{leftFlip(move,move,current);}
				if	(checkTop(move,move))		{topFlip(move,move,current);}
				if	(checkBot(move,move))		{botFlip(move,move,current);}
				if	(checkTopDiag(move,move))	{topDiag(move,move,current);}
				if	(checkBotDiag(move,move))	{botDiag(move,move,current);}
				if	(checkTopDiag(move,move))	{topDiag2(move,move,current);}
				if	(checkBotDiag(move,move))	{botDiag2(move,move,current);}
				if(current == first) {current=second;}
				else {current = first;}
				
			}
		} while (!hasMoved);
		drawBoard();
		
	}
	
	//Checking functions
	public boolean checkRight(int move, int next) {
		next++;
		System.out.println(next);
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkRight(move,next);}
		return false;
	}
	
	public boolean checkLeft(int move, int next) {
		next--;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkLeft(move,next);}
		return false;
	}
	
	public boolean checkTop(int move, int next) {
		next-=8;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkTop(move,next);}
		return false;
	}
	
	public boolean checkBot(int move, int next) {
		next+=8;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkBot(move,next);}
		return false;
	}
	
	public boolean checkTopDiag(int move, int next) {
		next-=7;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkTopDiag(move,next);}
		return false;
	}
	
	public boolean checkBotDiag(int move, int next) {
		next+=7;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkBotDiag(move,next);}
		return false;
	}
	
	public boolean checkTopDiag2(int move, int next) {
		next-=9;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkTopDiag2(move,next);}
		return false;
	}
	
	public boolean checkBotDiag2(int move, int next) {
		next+=9;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {System.out.println("checkRight is true"); return true;}
		if	(board[move].getPiece()!=board[next].getPiece()) {System.out.println("Recursion checkRight"); return checkBotDiag2(move,next);}
		return false;
	}
	
	//Flipping functions
	public boolean rightFlip(int move, int next, Player current) {
		//Checking the right of current Position
		next++;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("Flipped");
			return rightFlip(move,next,current);
		}
		
		return false;
	}
	
	public boolean leftFlip(int move, int next, Player current) {
		//Checking the right of current Position
		next--;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("Flipped");
			return leftFlip(move,next,current);
			}
		return false;
	}
	public boolean topFlip(int move, int next, Player current) {
		//Checking the top of current Position
		next-=8;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("top flipped");
			return topFlip(move,next,current);
			
			}
		
		return false;
	}
	public boolean botFlip(int move, int next, Player current) {
		//Checking the bottom of current Position
		next+=8;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("bot flipped");
			return botFlip(move,next,current);
			}
		
		return false;
	}
	
	public boolean topDiag(int move, int next, Player current) {
		//Checking the top of current Position
		next-=7;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("topDiag flipped");
			return topDiag(move,next,current);
			
			}
		
		return false;
	}
	public boolean botDiag(int move, int next, Player current) {
		//Checking the bottom of current Position
		next+=7;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("botDiag flipped");
			return botDiag(move,next,current);
			}
		return false;
	}
	
	public boolean topDiag2(int move, int next, Player current) {
		//Checking the top of current Position
		next-=9;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("topDiag2 flipped");
			return topDiag2(move,next,current);
			
			}
		
		return false;
	}
	public boolean botDiag2(int move, int next, Player current) {
		//Checking the bottom of current Position
		next+=9;
		if	(board[next].getPiece()=='.') {return false;}
		if	(board[move].getPiece()==board[next].getPiece()) {return false;}
		if	(board[move].getPiece()!=board[next].getPiece()) {
			board[next].flip(current);
			System.out.println("botDiag2 flipped");
			return botDiag2(move,next,current);
			}
		return false;
	}
		
	//Need to catch exception when array goes out of bound.
		
	
	

	//Method to draw default 8x8 board
	private void drawBoard() {
		char[] axisX = {'0','1','2','3','4','5','6','7'};
		int[] axisY = {0,8,16,24,32,40,48,56};
		
		//Static positions, will never change

		board[16] = new UnplayablePosition();
		board[24] = new UnplayablePosition();
		board[32] = new UnplayablePosition();
		board[40] = new UnplayablePosition();
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

	

}
