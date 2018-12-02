/* 
	Name: Zhixi Tan V00821283
	CSC110 Assignment 6 : TicTacToe.java
	Purpose: To play the game
	Input: Scanner, Random
	Output: playing the game and get the result
*/

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	public static void main(String[] args) {
		 int SIZE = 3;
         
         if(args.length>0) {
	        SIZE = Integer.parseInt(args[0]);
	        if(SIZE %3 !=0 ) {
		       System.out.println("not a multiple of 3");
	        }
         }


         char[][] gameBoard = new char[SIZE][SIZE];
		 Scanner s = new Scanner(System.in);
		 Random r = new Random(System.currentTimeMillis());
		 playGame(gameBoard, s, r);

	}
	/*
	 PURPOSE: play the game
	 INPUT: board, Scanner, Random
	 OUTPUT: playing the game and get who is the winner
	*/    
	public static void playGame(char[][] board, Scanner s, Random r){
		fillBoard(board);
		printArray(board);
		int chooseFirst=0;
		chooseFirst=whoFirst(r);
		int player1 = chooseFirst;
		play(s,board,player1);
	}
	/*
	 PURPOSE: fill the game board with '?'
	 INPUT: board
	 OUTPUT: geting a board with all '?'
    */    
	public static void fillBoard(char[][] board){
		for(int i=0; i<board.length;i++){
			for(int j=0; j<board[i].length;j++){
				board[i][j]='?';
			}
		}
	}
	/*
	 PURPOSE: print the board
	 INPUT: board
	 OUTPUT: get the standard game board
    */    
	public static char[][] printArray(char[][] board){
		System.out.print("  |");
		
		for(int i=0;i<board.length;i++){
			System.out.print(i+"|");
		}
	    
	    System.out.println();
		System.out.print("  ");
		
		for(int i=0;i<2*board.length+1;i++){
			System.out.print("-");
		}
		
		for(int i=0;i<board.length;i++){
			System.out.println();
			System.out.print(i+" |");
			for(int j=0; j<board[i].length;j++){
				System.out.print(board[i][j]+"|");
			}
		}
		
		return board;
	}
	/*
	 PURPOSE: to decide who is the first player
	 INPUT: Random
	 OUTPUT: get who is the first
	*/    
	public static int whoFirst(Random r){
		System.out.println();
	    int chooseFirst=r.nextInt(2);
		System.out.println();
		return chooseFirst;
	}
	/*
	 PURPOSE: play the game
	 INPUT: board, Scanner, Player1
	 OUTPUT: playing the game and get who is the winner
	*/    
	public static void play(Scanner s, char[][] board, int player1){
	  
	 boolean hasWon = false;
	  
	 while(hasWon == false){
		
		if(player1 == 0){
			System.out.println();
			System.out.println("X it is your turn!");
			System.out.println();
			System.out.println("enter the coordinates of an untaken cell in row column format");
			System.out.println("ie. 1 0 will place your mark in row 1 column 0 of the grid");
			System.out.println("your entry please...");
			System.out.println();
			
			int currentRow = s.nextInt();
			int currentColumn = s.nextInt();
			
			while(currentRow >= board.length || currentColumn >= board.length || currentRow < 0 || currentColumn < 0){
				System.out.println();
				System.out.println("bad cell coordinates");
				System.out.println("your entry please...");
				System.out.println();
				currentRow = s.nextInt();
				currentColumn = s.nextInt();
			}
			
			if(board[currentRow][currentColumn] == '?'){
				board[currentRow][currentColumn] = 'X';
			}else{
				System.out.println();
				System.out.println("bad cell coordinates");
				System.out.println("your entry please...");
				System.out.println();
				currentRow = s.nextInt();
				currentColumn = s.nextInt();
				board[currentRow][currentColumn] = 'X';

			}
			
						
			    System.out.println();
			    printArray(board);
			} 
		
		if(player1 == 1){
			
			System.out.println();
			System.out.println("O it is your turn!");
			System.out.println();
			System.out.println("enter the coordinates of an untaken cell in row column format");
			System.out.println("ie. 1 0 will place your mark in row 1 column 0 of the grid");
			System.out.println("your entry please...");
			System.out.println();
			
			int currentRow = s.nextInt();
			int currentColumn = s.nextInt();
			
			while(currentRow >= board.length || currentColumn >= board.length || currentRow < 0 || currentColumn < 0){
				System.out.println("bad cell coordinates");
				System.out.println("your entry please...");
				System.out.println();
				currentRow = s.nextInt();
				currentColumn = s.nextInt();
			}
			
			if(board[currentRow][currentColumn] == '?'){
				board[currentRow][currentColumn] = 'O';
			}else{
				System.out.println();
				System.out.println("bad cell coordinates");
				System.out.println("your entry please...");
				System.out.println();
				currentRow = s.nextInt();
				currentColumn = s.nextInt();
				board[currentRow][currentColumn] = 'O';

		    }
			           
			    System.out.println();
			    printArray(board);
		    }
		        System.out.println();
		        
		        player1=changePlayer(player1);
		  
		        
		        //hasWon=checkWin(board,hasWon);
		      
		        if(hasWon == true){
			       System.out.println();
			       System.out.println("you win!");
			       System.exit(0);
		        }
		
		    }      
		       
    }
		
	/*
	 PURPOSE: change the player
	 INPUT: player1
	 OUTPUT: changing the player
	*/    
	public static int changePlayer(int player1){
		if(player1 == 0){
			player1 = 1;
		}else if(player1 == 1){
			player1 = 0;
		}
		return player1;
	}
	/*
	 PURPOSE: check the win
	 INPUT: board, hasWon
	 OUTPUT: check who is the winner
	*/    
	public static boolean checkWin(char[][] board,boolean hasWon){
		
		for(int i=0; i<board.length; i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j] != 'X'){
					hasWon = false;
				}if(board[i][j] != 'O'){
					hasWon = false;
				}if(board[j][i] != 'X'){
					hasWon = false;
				}if(board[j][i] != 'O'){
					hasWon = false;
				}if(board[i][j] == 'X'){
                    hasWon = true;
				}if(board[i][j] == 'O'){
					hasWon = true;
				}if(board[i][board[i].length-j-1] == 'X'){
					hasWon = true;
				}if(board[i][board[i].length-j-1] == 'O'){
					hasWon = true;
				}if(board[0][j] == 'X'){
					hasWon = true;
				}if(board[0][j] == 'O'){
					hasWon = true;
				}	
	        }
	    }  
		
		return hasWon;
	}
	
	public static boolean isFull(char[][] board){
		boolean isItFull = false;
		for(int i=0; i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j] != '?') {
					return true;
				}
			}
		}
		
		return false;
	}
	
}

