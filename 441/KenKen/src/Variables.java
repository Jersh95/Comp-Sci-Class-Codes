import java.util.ArrayList;

/**
 * Created by Josh on 3/9/2016.
 */
public class Variables {
    boolean isAssigned;
    int assignment;
    int row;
    int col;
    ArrayList<Integer> domain;

    public Variables(int row, int col, int size) {
        this.row = row;
        this.col = col;
        initDomain(size);
    }


    public void initDomain(int size){
        domain = new ArrayList<Integer>();
        for(int i = 1; i <= size; i++){

            domain.add(i);
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public ArrayList<Integer> getDomain() {
        return domain;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public int getAssignment() {
        return assignment;
    }

    public int getAssignment(int row, int col) {
        return assignment;
    }

    public void setAssignment(int assignment) {
        this.assignment = assignment;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }


}
