package cpsc2150.extendedConnectX.models;

/**
        * @author Tirth Patel
        * @version 3.0
*/
abstract public class AbsGameBoard implements IGameBoard{
    @Override
    /**
     *print out the board
     * @pre NONE
     * @post toString = brd AND
     *       brd = #brd AND
     *
     * @return string of board
     */
    public String toString(){
        String ret = "|0|1|2|3|4|5|6|7|8|\n";
        for(int i = getNumRows() - 1; i >= 0; i--){
            for(int j = 0; j < getNumColumns(); j++){
                BoardPosition pos = new BoardPosition(i,j);
                ret = ret + "|" + whatsAtPos(pos);
            }
            ret = ret + "|\n";
        }


        return ret;
    }

}
