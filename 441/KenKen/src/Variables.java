import java.util.ArrayList;

/**
 * Created by Josh on 3/9/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 */
public class Variables {
    boolean isAssigned;
    int assignment;
    int row;
    int col;
    ArrayList<Integer> domain;

    /**
     * This is the constructor for the Variables
     * @param row - the row
     * @param col - the col
     * @param size - the size of the grid
     */
    public Variables(int row, int col, int size) {
        this.row = row;
        this.col = col;
        initDomain(size);
    }

    /**
     * This will initialize the domain for each Variable based on the size of the grid
     * @param size - the size of the grid
     */
    public void initDomain(int size){
        domain = new ArrayList<Integer>();
        for(int i = 1; i <= size; i++){
            domain.add(i);
        }
    }

    /**
     * getter for the row
     * @return - the row
     */
    public int getRow() {
        return row;
    }

    /**
     * getter for the col
     * @return - the col
     */
    public int getCol() {
        return col;
    }

    /**
     * getter for the domain list
     * @return - the list
     */
    public ArrayList<Integer> getDomain() {
        return domain;
    }

    /**
     * getter to determine if the variable has been assigned
     * @return - if the variable has been assigned
     */
    public boolean isAssigned() {
        return isAssigned;
    }

    /**
     * getter for the variable assignment
     * @return - the assignment value
     */
    public int getAssignment() {
        return assignment;
    }

    public int getAssignment(int row, int col) {
        return assignment;
    }

    /**
     * setter for the variable assignment
     * @param assignment - the assignment value
     */
    public void setAssignment(int assignment) {
        this.assignment = assignment;
    }

    /**
     * setter to determine if the variable has been assigned
     * @param assigned - if the variable has been assigned
     */
    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }
}
