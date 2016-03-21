import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Josh Jacobsen on 3/2/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 */
public class KenKenPuzzle {
    private String[][] puzzle;
    private int numRows;
    private ArrayList<Constraints> constraintList = new ArrayList<Constraints>();
    private Variable[][] variablesTotal;

    private int[][] groupIndex;
    private ArrayList<Integer> queue = new ArrayList<Integer>();

    /**
     * This is a simple constructor for the puzzle, it will read in the file and create the puzzle
     * @param file
     */
    public KenKenPuzzle(File file){
        createPuzzle(file);
    }

    /**
     * This method will read the user entered file and create each line into a Constraints object and add all of the constraints
     * to an ArrayList of Constraints.
     * @param file - the user entered file
     */
    public void createPuzzle(File file) {
        try {
            Scanner scanner = new Scanner(file);
            setNumRows(Integer.parseInt(scanner.nextLine()));
            this.puzzle = new String[getNumRows()][getNumRows()];
            this.groupIndex = new int[getNumRows()][getNumRows()];
            variablesTotal = new Variable[getNumRows()][getNumRows()];
            for(int row = 0; row < getNumRows(); row++){
                for(int col = 0; col < getNumRows(); col++){
                    variablesTotal[row][col] = new Variable(row, col, numRows);
                    variablesTotal[row][col].initDomain(numRows);
                }
            }
            int constrCount = 0;

            //This will read in the variables adding them to a Variables ArrayList for each Constraint
            while (scanner.hasNext()) {
                int sol = 0;
                String sym = "";
                String temp = "";
                ArrayList<Variable> varList = new ArrayList<Variable>();
                while (scanner.hasNextInt()) {
                    int row = scanner.nextInt();
                    System.out.println("Row: " + row);
                    int col = scanner.nextInt();
                    System.out.println("Col: " + col);
                    Variable variable = variablesTotal[row][col];
                    varList.add(variable);

                    groupIndex[row][col] = constrCount;
                    System.out.println("COUNT: " + constrCount);
                    System.out.println("GRID: " + groupIndex[row][col]);
                    System.out.println("---------------");
                }

                //This will read in everything after the last point, the colon, the solution value, and the solution arithmetic symbol
                temp = scanner.nextLine();
                sym = Character.toString(temp.charAt(temp.length() - 1));
                sol = Integer.parseInt(temp.substring(2, temp.length() - 1));

                //Add each constraint to the ArrayList
                Constraints constraint = new Constraints(varList, sol, sym);
                this.constraintList.add(constraint);
                constrCount++;
                System.out.println("Sym: " + constraintList.get(constraintList.size()-1).getArithSol() + constraintList.get(constraintList.size()-1).getArithSym());
                //System.out.println(varList.get(1).);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will generate the next arc constency step once the user clicks the screen
     */
    public void generateMove()
    {

    }

    /**
     * This will perform the node consistency for the puzzle
     * @param list - the list containing the constraints
     */
    public void nodeConsistency(ArrayList<Constraints> list){
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).getArithSym().equals("=")){
                list.get(i).getPoints().get(0).setAssignment(list.get(i).getArithSol());
                list.get(i).getPoints().get(0).setAssigned(true);

                //this will loop through the domain and remove everything except what it is assigned to
                for(int j = 1; j <= getNumRows(); j++) {
                    if(j != list.get(i).getPoints().get(0).getAssignment()) {
                        list.get(i).getPoints().get(0).domain.remove(j);
                    }
                }
            }
        }
    }



    public void formInequality(){
        for(int row = 0; row < numRows; row++){
            for(int var = 0; var < numRows; var++){
                for(int col = 0; col < numRows; col++){
                    if(var != col) {
                        Variable var1 = variablesTotal[var][col];
                        Variable var2 = variablesTotal[row][col];
                        ArrayList<Variable> conVars = new ArrayList<Variable>();
                        conVars.add(var1);
                        conVars.add(var2);
                        Constraints constr = new Constraints(conVars, 0, "!=");
                        constraintList.add(constr);
                    }
                }
            }
        }
    }


    /**
     * This will perform the arc consistency for the puzzle
     * @param list - the list containing the constraints
     */
    public boolean arcConsistency(ArrayList<Constraints> list){
        ArrayList<Constraints> queue = new ArrayList();
        boolean revised = false;
        String constrType = "";
        for(int i = 0; i < list.size(); i++){
            queue.add(list.get(i));
        }
        while (queue.size()>0){
            revise()
        }




        while(queue.size()>0){
            for(int i = 0; i < ; i++){
                for(int j = 0; j < ; j++){
                    if(revise(list, list.get(i).getPoints().get(i),list.get(i).getPoints().get(j)) == true){
                        if(list.get(i).getPoints().get(j).domain.size() == 0){
                            return false;
                        }
                        //for each Xk in Xi
                        //queue.add(Xk, Xi)
                    }
                }
            }
        }
        return true;
    }


    public boolean revise(ArrayList<Constraints> list, Variable var1, Variable var2){
        boolean revised = false;

        //this will get the last item on the list and then delete it
        while(queue.size()>0){
            list.get(list.size()-1);

            switch (list.get(list.size()-1).getArithSym()){
                case "+": reviseAddition(list.get(list.size()-1));
                    revised = true;
                    break;
                case "-": reviseSubtraction(list.get(list.size()-1));
                    revised = true;
                    break;
                case "*": reviseMultiplication(list.get(list.size()-1));
                    revised = true;
                    break;
                case "/": reviseDivision(list.get(list.size()-1));
                    revised = true;
                    break;
                case "!=": reviseInequality(list.get(list.size()-1));
                    revised = true;
                    break;
            }
            list.remove(list.size()-1);
        }
        return revised;
    }

    /**
     * Revises the addition constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseAddition(Constraints c1){
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue = c1.getArithSol()-var1.domain.get(i);
            if(!var2.domainContains(neededValue)){
                var1.domain.remove(i);
                revised = true;
            }
        }
        for(int i = 0; i < var2.domain.size(); i++){
            int neededValue = c1.getArithSol()-var2.domain.get(i);
            if(!var1.domainContains(neededValue)){
                var2.domain.remove(i);
                revised = true;
            }
        }
        return revised;
    }

    /**
     * Revises the multiplication constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseMultiplication(Constraints c1){
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue = c1.getArithSol()/var1.domain.get(i);
            if(!var2.domainContains(neededValue)){
                var1.domain.remove(i);
                revised = true;
            }
        }
        for(int i = 0; i < var2.domain.size(); i++){
            int neededValue = c1.getArithSol()/var2.domain.get(i);
            if(!var1.domainContains(neededValue)){
                var2.domain.remove(i);
                revised = true;
            }
        }
        return revised;
    }

    /**
     * Revises the subtraction constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseSubtraction(Constraints c1){
        boolean revised = false;

        return revised;
    }

    /**
     * Revises the division constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseDivision(Constraints c1){
        boolean revised = false;

        return revised;
    }

    /**
     * Revises the inequality constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseInequality(Constraints c1){
        boolean revised = false;

        return revised;
    }

    /**
     * getter for grid size
     * @return - the size
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * setter for grid size
     * @param numRows - the size
     */
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    /**
     * getter for group index
     * @return - the group index
     */
    public int[][] getGroupIndex() {
        return groupIndex;
    }

    /**
     * setter for group index
     * @param groupIndex - group index
     */
    public void setGroupIndex(int[][] groupIndex) {
        this.groupIndex = groupIndex;
    }

    /**
     * getter for constraint list
     * @return - the list
     */
    public ArrayList<Constraints> getConstraintList() {
        return constraintList;
    }

    /**
     * setter for constraint list
     * @param constraintList - the list
     */
    public void setConstraintList(ArrayList<Constraints> constraintList) {
        this.constraintList = constraintList;
    }
}
