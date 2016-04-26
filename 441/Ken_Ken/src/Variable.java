import java.util.ArrayList;

/**
 * Created by Josh on 3/9/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 *
 *  The Variable class stores the information for the variables inside each Constraint
 */
public class Variable {
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
    public Variable(int row, int col, int size) {
        this.row = row;
        this.col = col;
        initDomain(size);
    }

    public String toString(){
        String info = row+ "," +  col + "   (";
        for(int i = 0; i < domain.size(); i++){
            info += domain.get(i) + ",";
        }
        info = info.substring(0,info.length()-1) + ")";

        return info;
    }

    public String domainToString(){
        String domString = "";
        for(int i = 0; i < domain.size(); i++){
            domString+=domain.get(i) + " ";
        }


        return domString;
    }

    public boolean domainContains(int neededValue){
        for(int i = 0; i < domain.size(); i++){
            if(domain.get(i) == neededValue){
                return true;
            }
        }
        return false;
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
     * create a setdomain instead of removing the domain
     */
    public void setSingleton (int value){
        domain = new ArrayList<Integer>();
        domain.add(value);
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

    public void purgeValue(ArrayList<Integer> purgeList){
        for(int i = 0; i < purgeList.size(); i++){
            for(int k = 0; k < domain.size(); k++){
                if(purgeList.get(i) == domain.get(k)){
                    domain.remove(k);
                    break;
                }
            }
        }
    }

    public boolean removeDomValue(int value){
        for(int i = 0; i < domain.size(); i++){
            if(domain.get(i) == value){
                domain.remove(i);
                return true;
            }
        }
        return false;
    }

    public void checkForSingleton(){
        //boolean isSingleton = false;
        if(domain.size() == 1){
            setAssigned(true);
            setAssignment(domain.get(0));
            setSingleton(domain.get(0));

            //isSingleton = true;
        }
        //return isSingleton;
    }


}
