import java.util.Scanner;

class Main {
  //function for printing the board
  public static void drawBoard (char [][] board) {
    int i; int j;
    for (i=0; i<board.length; i++) {
      for (j=0; j<board[i].length; j++) {
        System.out.print(board[i][j]);

        if (j % 2 == 0 && j != 0) {
          System.out.println (" ");
        }
      }
    }
  }

  //determine if the board is fully filled up
  public static boolean endOfGame (char [][] board) {
    int i; int j;
    for (i=0; i<board.length; i++) {
      for (j=0; j<board[i].length; j++) {
        if (board[i][j] == '-') {
          return (false);
        }
      }
    }
    return (true);
  }
  
  public static char wonGame (char [][] board) {
    int i; int j;
    for (i=0; i<3; i++) {
      if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
        return board[i][0];
      } //test if 1 row has been filled with x or o

      else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
        return board[0][i];
      } //column

      else if (board[0][i] == board[1][1] && board[1][1] == board[2][2] && board[0][i] != '-') {
        return board[0][i];
      } //diagonal 1

      else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
        return board[0][2];
      } //diagonal 2
    }
    return ' ';
  }
  
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}}; //create 2d array for board

    System.out.println ("Welcome to 3x3 Tic Tac Toe! This is an interactive game you can play with a friend." + '\n');
    System.out.println ("NOTE: rows and columns start from 0 (not 1) and end at 2. Have fun :)" + '\n');
		System.out.print("Player 1 name: ");
		String p1 = myObj.nextLine();
		System.out.print("Player 2 name: ");
		String p2 = myObj.nextLine();
    
    boolean player1 = true;
    
    while (endOfGame(board) == false) {
      System.out.println (" ");
      drawBoard(board);

      char c;
      if (player1) {
        System.out.println ("Player 1's turn (x): ");
        c = 'x';
        System.out.println ("row: ");
        int row = myObj.nextInt();
        System.out.println ("column: ");
        int col = myObj.nextInt();
        
        if (row < 0 || row > 2 || col < 0 || col > 2) {
          System.out.println ("out of bounds, try again!");
        } //test if out of bounds
        else if (board[row][col] != '-') {
          System.out.println ("this spot is taken, try again!");
        } //test if the spot is empty
        else {
          board[row][col] = c; //add x to the index in array
          player1 = false; //change to false so player 2 goes
        }
      }
        
      else {
        System.out.println ("Player 2's turn (o): ");
        c = 'o';
        System.out.println ("row: ");
        int row = myObj.nextInt();
        System.out.println ("column: ");
        int col = myObj.nextInt();
        
        if (row < 0 || row > 2 || col < 0 || col > 2) {
          System.out.println ("out of bounds, try again!");
        }
        else if (board[row][col] != '-') {
          System.out.println ("this spot is taken, try again!");
        }
        else {
          board[row][col] = c;
          player1 = true;
        }
      }

      if (endOfGame(board) == true) {
        System.out.println ('\n');
        drawBoard(board);
        System.out.println ("It's a tie!");
        break;
      }

      if(wonGame(board) == 'x') {
        System.out.println ('\n'); //test if player 1 won with x
        drawBoard(board);
				System.out.println(p1 + " won!");
        break;
		  }
      else if (wonGame(board) == 'o') {
        System.out.println ('\n'); //test if player 2 won with o
        drawBoard(board);
        System.out.println (p2 + " won!");
        break;
      }
    }
  }
}