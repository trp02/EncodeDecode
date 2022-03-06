package cpsc2150.extendedConnectX.models;

import cpsc2150.extendedConnectX.models.AbsGameBoard;
import cpsc2150.extendedConnectX.models.BoardPosition;

import java.util.Arrays;

/**
     * This class represents the whole board and will hold methods relating to actions
     *
     * @author Tirth Patel
     * @version 3.0
     * @invariant board[r][c][ r >= 0 AND r < 6 AND c >= 0 AND c < 9] AND
    no gaps between tokens
      Correspondence brd = board
     */

    public class GameBoard extends AbsGameBoard implements IGameBoard {



        private char[][] board;
        final int numToWin = 5;
        public GameBoard() {
            board = new char[6][9];
            for (char[] chars : board) {
                Arrays.fill(chars, ' ');
            }
        }


        public void placeToken(char p, int c) {
            for(int i = 0; i < board.length; i++){
                if(board[i][c] == ' '){
                    board[i][c] = p;
                    break;
                }
            }
        }






        public char whatsAtPos(BoardPosition pos) {
            return board[pos.getRow()][pos.getColumn()];
        }


        public int getNumRows() {
            return board.length;
        }

        public int getNumColumns() {
            return board[0].length;
        }

        public int getNumToWin() {
            return numToWin;
        }


        public boolean checkTie(){
            boolean ret = true;
            for(int i = 0; i < getNumColumns(); i++){
                if(board[getNumRows() - 1][i] == ' '){
                    ret = false;
                }
            }
            return ret;
        }

        public boolean checkVertWin(BoardPosition pos, char p) {
            boolean ret = false;
            int col = pos.getColumn();
            for(int i = 0; i <= getNumRows() - getNumToWin(); i++){
                if(board[i][col] == p){

                    for(int j = 1; j < numToWin; j++){
                        if(board[i+j][col] == p){
                        }
                        else{
                            break;
                        }
                        if(j == numToWin - 1){
                            ret = true;
                        }
                    }
                }
            }
            return ret;
        }


        public boolean checkHorizWin(BoardPosition pos, char p) {
            boolean ret = false;
            int row = pos.getRow();

            for(int i = 0; i <= getNumColumns() - getNumToWin(); i++){
                if(board[row][i] == p){

                    for(int j = 1; j < numToWin; j++){
                        if(board[row][i+j] == p){
                        }
                        else{
                            break;
                        }
                        if(j == numToWin - 1){
                            ret = true;
                        }
                    }
                }
            }
            return ret;
        }

    public boolean checkDiagWin(BoardPosition pos, char p) {
        int row = pos.getRow();
        int column = pos.getColumn();
        int maxRow = getNumRows(), minRow = -1, maxColumn = getNumColumns(), minColumn = -1;
        System.out.println(row + " START " + column);
        int ascendDiag = 1;
        int descedDiag = 1;
        for(int i = 1; i < numToWin; i++){
            int row2 = row + i;
            int column2 = column + i;
            if(row2 > minRow && row2 < maxRow && column2 < maxColumn && column2 > minColumn){
                if(board[row2][column2] == p){
                    System.out.println(row + " " + column);

                    ascendDiag++;
                }
                else{
                    break;
                }
            }
        }

        for(int i = 1; i < numToWin; i++){
            int row2 = row - i;
            int column2 = column - i;
            if(row2 > minRow && row2 < maxRow && column2 < maxColumn && column2 > minColumn){
                if(board[row2][column2] == p){
                    System.out.println(row + " " + column);
                    ascendDiag++;
                }
                else{
                    break;
                }
            }
        }
        if(ascendDiag >= numToWin){
            return true;
        }

        for(int i = 1; i < numToWin; i++){
            int row2 = row + i;
            int column2 = column - i;
            if(row2 > minRow && row2 < maxRow && column2 < maxColumn && column2 > minColumn){
                if(board[row2][column2] == p){
                    System.out.println(row + " " + column);

                    descedDiag++;
                }
                else{
                    break;
                }
            }
        }

        for(int i = 1; i < numToWin; i++){
            int row2 = row - i;
            int column2 = column + i;
            if(row2 > minRow && row2 < maxRow && column2 < maxColumn && column2 > minColumn){
                if(board[row2][column2] == p){
                    System.out.println(row + " " + column);
                    descedDiag++;
                }
                else{
                    break;
                }
            }
        }
        if(descedDiag >= numToWin){
            return true;
        }





        return false;
    }


}
