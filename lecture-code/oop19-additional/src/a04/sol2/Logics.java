package a04.sol2;

public interface Logics{
    
    /**
     * selects a cell
     * 
     * @param row
     * @param col
     * @return whether this cell is accepted
     */
    boolean hit(int row, int col);
            
    /**
     * @return if there are no more cells to hit
     */
    boolean end();
}
