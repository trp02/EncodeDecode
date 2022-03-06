package cpsc2150.extendedConnectX.models;

import cpsc2150.extendedConnectX.models.BoardPosition;

public interface IGameBoard {


    /**
     * places the character p in column c. The token will be placed in
     * the lowest available row in column c.* @param p character to place on board
     * @param c column chosen
     * @pre p = 'X' OR p = 'O' AND
     *      0 <= c AND c < 9 AND
     *      checkIfFree(c) = true
     * @post brd = #brd[except there is another character(p) in column c AND
     *		brd[lowest available position in c] = p
     */
    public void placeToken(char p, int c);



    /**
     * returns what is in the cpsc2150.extendedConnectX.models.GameBoard at position pos
     *  If no marker is there, it returns a blank space char.
     * @param pos a position on the board
     * @return the char at the position on the board
     *
     * @pre pos = [within bounds]
     * @post whatsAtPos = 'X' OR whatsAtPos = 'O' OR whatsAtPos = ' ' AND
     *       brd = #brd
     */

    public char whatsAtPos(BoardPosition pos);


    /**
     *This function returns the number of rows in the board
     * @return int which is number of rows
     * @pre NONE
     * @post getNumRows() = [number of rows] AND
     *       brd = #brd
    */
    public int getNumRows();

    /**
     *This function returns the number of columns in the board
     * @return int which is number of columns
     * @pre NONE
     * @post getNumColumns() = [number of columns] AND
     *       brd = #brd
     */
    public int getNumColumns();

    /**
     *This function returns the number of tokens to win in the board
     * @return int which is number of tokens to win
     * @pre NONE
     * @post getNumToWin() = [number of tokens to win] AND
     *       brd = #brd
     */
    public int getNumToWin();


    /**
     * returns true if the column can accept another token; false otherwise.
     *
     * @param c is the column number that is to be checked
     * @return is true or false
     * @pre 0 <= c AND c < 9
     * @post checkIfFree = true iff whatsAtPos(brd[5][c]) == ' ' AND
     * brd = #brd
     */

    default public boolean checkIfFree(int c) {
       char token = whatsAtPos(new BoardPosition(5,c));
       if(token != ' '){
           return false;
       }
       else{
           return true;
       }

    }

    /**
     * checks to see if the last token placed (which was placed in
     * position pos by player p) resulted in 5 in a row horizontally. Returns
     * true if it does, otherwise false
     * <p>
     * This method checks if there are 5 matching characters horizontally
     *
     * @param pos board position where the token was place
     * @param p   character being checked for win
     * @return true or false depending on if there is a win
     * @pre pos = [position of last play]AND
     * pos =[in bounds] AND
     * p = 'X' OR p = 'O' AND
     * 0 <= pos.getRow() < MAX_ROW_NUM AND
     * 0 <= pos.getColumn() < MAX_COLUMN_NUM
     * @post checkHorizWin = true iff [there are enough characters(p) to the left or right in row to win] AND
     * checkHorizWin = false iff [ not enough characters to left or right of pos to win] AND
     * brd = #brd
     */

    default public boolean checkHorizWin(BoardPosition pos, char p) {
        return false;
    }


    /**
     * checks to see if the last token placed (which was placed in
     * position pos by player p) resulted in 5 in a row vertically. Returns
     * true if it does, otherwise false
     *
     * @param pos board position where the token was placed
     * @param p   character being checked for win
     * @return true or false depending on if there is a win
     * @pre pos = [position of last play]AND
     * pos = [in bounds]
     * p = 'X' OR p = 'O' AND
     * 0 <= pos.getRow() < MAX_ROW_NUM AND
     * 0 <= pos.getColumn() < MAX_COLUMN_NUM
     * @post checkVertWin = true iff[there is a match of 5 characters(p) in the column] AND
     * brd = #brd
     */

    default public boolean checkVertWin(BoardPosition pos, char p) {

        return false;
    }


    /**
     * checks to see if the last token placed (which was placed in
     * position pos by player p) resulted in 5 in a row diagonally. Returns
     * true if it does, otherwise false
     * Note: there are two diagonals to check
     *
     * @param pos board position where the token was placed
     * @param p   character being checked for win
     * @return true or false depending on if there is a win
     * @pre pos = [position on latest play] AND
     * pos = [within valid bounds] AND
     * p = 'X' OR p = 'O'
     * @post checkDiagWin = true iff[there is a match of 5 characters(p) diagonally from the pos AND
     * brd = #brd
     */
    default public boolean checkDiagWin(BoardPosition pos, char p) {
        return false;
    }


    /**
     * //this function will check to see if the last token placed in
     * column c resulted in the player winning the game. If so it will return
     * true, otherwise false.
     * Note: this is not checking the entire board for a win, it is
     * just checking if the last token placed results in a win.
     * <p>
     * Function checks column to see if a player has won
     *
     * @param c column to be checked for win
     * @return true or false depending on win
     * @pre 0 <= c AND c < 9 AND
     * pos = boardPosition[latest play]
     * @post checkForWin = true iff ( checkHorizWin = true OR checkVertWin = true OR checkDiagWin = true) AND
     * brd = #brd
     */
    default public boolean checkForWin(int c) {
        BoardPosition send = new BoardPosition(0,c);
        for(int i = getNumRows() - 1; i >= 0; i--){
            send = new BoardPosition(i, c);
            if(whatsAtPos(send) != ' '){
                break;
            }
        }
        if(checkVertWin(send, whatsAtPos(send))){
            return true;
        }
        if(checkHorizWin(send, whatsAtPos(send))){
            return true;
        }
        if(checkDiagWin(send, whatsAtPos(send))){
            return true;
        }

        return false;
    }

    /**
     * this method will be implemented very similarly to
     * whatsAtPos, but it's asking a different question. We only know they
     * will be similar because we know cpsc2150.extendedConnectX.models.GameBoard will contain a 2D array. If
     * the data structure were to change in the future, these two methods
     * could be radically different.
     * <p>
     * This method checks if a player is at the position
     *
     * @param pos    position on the board that is to be checked
     * @param player check position to see if the token on the board matches the playe
     * @return true or false depending on token at position
     * @pre pos = [within bounds] AND
     * (player = 'X' OR player = 'O')
     * @post isPlayerAtPos = true iff whatsAtPos(pos) = player AND
     * brd = #brd
     */
    default public boolean isPlayerAtPos(BoardPosition pos, char player) {
        return false;
    }

    /**
     * this function will check to see if the game has resulted in a
     * tie. A game is tied if there are no free board positions remaining.
     * You do not need to check for any potential wins because we can assume
     * that the players were checking for win conditions as they played the
     * game. It will return true if the game is tied and false otherwise.
     * <p>
     * Checks to see if game is tied
     *
     * @return true or false depending on if board is free
     * @pre checkWin(c) = false AND
     * @post checkTie = true iff [all columns in row 5 are full] AND
     * brd = #brd
     */

    default public boolean checkTie() {
        return false;
    }

}
