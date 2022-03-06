package cpsc2150.extendedConnectX.models;


import java.util.Scanner;

public class GameScreen {

    /**
     * main function to run the game
     * @param args array of string
     * @post [game will be played that results in tie or win for either player]
     */
    public static void main(String[] args){
        Scanner kyb = new Scanner(System.in);

        char player = 'X';
        char playAgain = 'y';
        IGameBoard board = new GameBoard();
        boolean gameCont = true;

        while(playAgain == 'y'){
            int column = 0;
            while(gameCont){
                System.out.println(board.toString());
                board.placeToken(player, column = userInput(board,player));


                if(board.checkForWin(column)){
                    System.out.println(board.toString());
                    System.out.println("Player " + player + " Won!" );
                    gameCont = false;
                }
                else if(board.checkTie()){
                    System.out.println(board.toString());
                    System.out.println("Game is tie");
                    gameCont = false;
                }

                if(player == 'X'){
                    player = 'O';
                }
                else{
                    player = 'X';
                }

            }

            System.out.println("Would you like to play again? Y/N");
            playAgain = kyb.next().charAt(0);

            if(playAgain == 'y' || playAgain == 'Y'){
                board = new GameBoard();
                gameCont = true;
                player = 'X';
            }

        }


    }

    /**
     * helper function to take user input and check if valid
     * @param x object of type gameboard
     * @return a valid column chosen by user
     * @pre x = valid gameBoard
     */
    private static int userInput(IGameBoard x, char player){
        Scanner kyb = new Scanner(System.in);
        System.out.println("Player " + player + ", what column do you want to place your marker in?");

        int clm = kyb.nextInt();
        kyb.nextLine();

        if(clm < 0){
            System.out.println("Column cannot be less than 0");
            return userInput(x, player);
        }
        if(clm > 8){
            System.out.println("Column cannot be greater than 8");
            return userInput(x, player);
        }

        if(x.checkIfFree(clm)){
            return clm;
        }
        else{
            System.out.println("Column is full");
            return userInput(x, player);
        }

    }
}
