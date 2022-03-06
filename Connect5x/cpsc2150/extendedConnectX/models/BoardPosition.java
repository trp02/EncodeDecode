package cpsc2150.extendedConnectX.models;

/**
 * This class is used to keep track of cells on the board
 *
 * @author Tirth Patel
 * @version 3.0
 *
 * @invariant row >= 0 AND row <= 5 AND column >= 0 AND column <= 8
 */


public class BoardPosition{

    private int row;
    private int column;

    /**
     * This constructor creates a new cell in the specified row and column
     *
     * @param r is the cell's row.
     * @param c is the cell's column.
     * @pre row >= 0 AND row <= 5 AND column >= 0 AND column <= 8
     * @post row = r AND column = c
     */
    public BoardPosition(int r, int c) {

        row = r;
        column = c;
    }

    /**
     * Getter function for the row
     *
     * @return the row of the cell
     * @post getRow = r AND
     * row = #row AND
     * column = #column
     */
    public int getRow() {
        return row;
    }


    /**
     * Getter function for the column
     *
     * @return the column of the cell
     * @post getColumn = c AND
     * row = #row AND
     * column = #column
     */
    public int getColumn() {
        return column;
    }


    /**
     * Checks if two board positions are equal
     *
     * @param pos2 is an object of the class cpsc2150.extendedConnectX.models.BoardPosition
     * @return True if pos2 row and column equals the row and column for this object
     * @pre pos2 should not be NULL
     * @post equals = true OR return = false AND
     * row = #row AND
     * column = #column
     */
    public boolean equals(Object pos2) {
        return false;
    }

    /**
     *print out the cell
     * @pre NONE
     * @post toString = [row and column of current cell] AND
     *       brd = #brd AND row = #row AND column = #colmun
     *
     * @return string of cell
     */
    public String toString(){
        return null;
    }


}