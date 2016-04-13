import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Josh Jacobsen on 3/2/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 *
 *  The KenKenPuzzle class handles anything related to calculations and functions affecting the puzzle
 */
public class KenKenPuzzle {
    private String[][] puzzle;
    private int numRows;
    private ArrayList<Constraint> constraintList = new ArrayList<Constraint>();
    private Variable[][] variablesTotal;
    private boolean isNoded = false;
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
                    int col = scanner.nextInt();
                    Variable variable = variablesTotal[row][col];
                    varList.add(variable);

                    groupIndex[row][col] = constrCount;
                }

                //This will read in everything after the last point, the colon, the solution value, and the solution arithmetic symbol
                temp = scanner.nextLine();
                sym = Character.toString(temp.charAt(temp.length() - 1));
                sol = Integer.parseInt(temp.substring(2, temp.length() - 1));

                //Add each constraint to the ArrayList
                System.out.println("solution: " + sol + " symbol: " + sym);
                Constraint constraint = new Constraint(varList, sol, sym);
                this.constraintList.add(constraint);
                constrCount++;


            }

            System.out.println("Constraint list size: " + constraintList.size());
            formInequality();
            System.out.println("New Constraint list size: " + constraintList.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will generate the next arc constency step once the user clicks the screen
     */
    public void generateMove() {
        //printConstr(constraintList);
        for(int row = 0; row < variablesTotal.length; row++) {
            for(int col = 0; col < variablesTotal[row].length; col++) {
                //System.out.println("Variables total: " + variablesTotal[row][col].toString());
            }
        }
        if (isNoded == false){
            nodeConsistency(constraintList);
            for(int row = 0; row < variablesTotal.length; row++) {
                for (int col = 0; col < variablesTotal[row].length; col++) {
                    //System.out.println("Variables total: " + variablesTotal[row][col].toString());
                }
            }
        }
        else {
            arcConsistency(constraintList);
        }
    }

    /**
     * This will perform the node consistency for the puzzle
     * @param list - the list containing the constraints
     */
    public void nodeConsistency(ArrayList<Constraint> list){
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).getArithSym().equals("=")) {
                //System.out.println("inside the if loop");
                Variable curVar =  list.get(i).getPoints().get(0);
                int val = list.get(i).getArithSol();
                curVar.setAssignment(val);
                curVar.setAssigned(true);
                curVar.setSingleton(val);

            }
        }
        System.out.println("Node Consistency Performed");
        isNoded = true;
    }

    /**
     * Forms the inequality constraints and adds it to the total constraint list
     */

    //this is only adding constraints horizontally and not vertically
    public void formInequality(){
        for(int row = 0; row < numRows; row++){
            for(int var = 0; var < numRows; var++){
                for(int col = 0; col < numRows; col++){
                    if(var != col) {
                        Variable var1 = variablesTotal[row][var];
                        Variable var2 = variablesTotal[row][col];
                        ArrayList<Variable> conVars = new ArrayList<Variable>();
                        conVars.add(var1);
                        conVars.add(var2);
                        Constraint constr = new Constraint(conVars, 0, "!=");
                        constraintList.add(constr);
                        System.out.println("Inequality Constr: " + var1.getRow()+"," + var1.getCol() + "    " + var2.getRow()+","+var2.getCol());
                    }
                }
            }
        }
    }

    /**
     * This will perform the arc consistency for the puzzle
     * @param list - the list containing all of the constraints
     */
    public boolean arcConsistency(ArrayList<Constraint> list){
        System.out.println("Arc Consistency Attempted");
        Stack queue = new Stack();
        boolean revised = false;
        String constrType = "";
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getArity() == 2) {
                queue.push(list.get(i));
            }
        }

        while (queue.size()>0){
            Constraint topConstr = (Constraint) queue.pop();
            //System.out.println("Top Constr: " + topConstr.getPoints());
            if(revise(topConstr)){
                revised = true;
            }
        }
        return true;
    }

    /**
     * Determine the passed constraint's symbol and call it's corresponding method
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean revise(Constraint c1){
        boolean revised = false;
        switch (c1.getArithSym()){
//            case "+": reviseAddition(c1);
//                revised = true;
//                break;
//            case "-": reviseSubtraction(c1);
//                revised = true;
//                break;
//            case "x": reviseMultiplication(c1);
//                revised = true;
//                break;
//            case "/": reviseDivision(c1);
//                revised = true;
//                break;
            case "!=": reviseInequality(c1);
                revised = true;
                break;
            default:
                System.out.println("Default case performed  " + c1.getArithSym());
                break;
        }
        return revised;
    }

    /**
     * Revises the inequality constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseInequality(Constraint c1){
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        //System.out.println("var1 domain size: " + var1.domain.size() + "    var1 points: " + var1.getRow()+ "," + var1.getCol());
        //System.out.println("var2 domain size: " + var2.domain.size() + "    var2 points: " + var2.getRow()+ "," + var2.getCol());
        boolean revised = false;
        ArrayList<Integer> toPurge = new ArrayList<>();
        //check if var1 is assigned
        if(var1.isAssigned()){
            //if it is then remove its value from var2's domain
            for(int i = 0; i < var2.domain.size(); i ++){
                if(var2.domain.get(i) == var1.getAssignment()){
                    toPurge.add(var2.domain.get(i));
                    revised = true;
                    continue;
                }
            }
        }
        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
        }
        //check if var2 is assigned
        if(var2.isAssigned()){
            //if it is then remove its value from var1's domain
            for(int i = 0; i < var1.domain.size(); i++){
                if(var1.domain.get(i) == var2.getAssignment()){
                    toPurge.add(var1.domain.get(i));
                    revised = true;
                    continue;
                }
            }
        }
        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
        }
        return revised;
    }

    /**
     * Revises the addition constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseAddition(Constraint c1){
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        ArrayList<Integer> toPurge = new ArrayList<>();

        //attempts to solve for >=2 arity by testing all of the possible combinations for the sum
        for(int i = 0; i < var1.domain.size(); i++){

            //loop through the domain of the variable and test the domains against the needed value
            int neededValue = c1.getArithSol()-var1.domain.get(i);

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if(!var2.domainContains(neededValue)){
                toPurge.add(var1.domain.get(i));
                revised = true;
            }
        }

        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
        }

        //attempts to solve for >=2 arity by testing all of the possible combinations for the sum
        for(int i = 0; i < var2.domain.size(); i++){

            //loop through the domain of the variable and test the domains against the needed value
            int neededValue = c1.getArithSol()-var2.domain.get(i);

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if(!var1.domainContains(neededValue)){
                toPurge.add(var2.domain.get(i));
                revised = true;
            }
        }
        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
        }
        return revised;
    }

    /**
     * Revises the multiplication constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseMultiplication(Constraint c1) {
        System.out.println("inside reviseMultiplication        " + c1.toString());
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        ArrayList<Integer> toPurge = new ArrayList<>();
        //attempts to solve for >=2 arity by testing all of the possible combinations for the product
        for (int i = 0; i < var1.domain.size(); i++) {
            int neededValue = 0;
            //loop through the domain of the variable and test the domains against the needed value
            if (c1.getArithSol() % var1.domain.get(i) == 0) {
                neededValue = c1.getArithSol() / var1.domain.get(i);
            } else {
                toPurge.add(var1.domain.get(i));
                System.out.println("not factor, add to purge");
                continue;
            }

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if (!var2.domainContains(neededValue)) {
                toPurge.add(var1.domain.get(i));
                System.out.println("no memeber, add to purge");
                revised = true;
            }
        }

        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
        }

        for (int i = 0; i < var2.domain.size(); i++) {
            int neededValue = 0;
            //loop through the domain of the variable and test the domains against the needed value
            if (c1.getArithSol() % var2.domain.get(i) == 0) {
                neededValue = c1.getArithSol() / var2.domain.get(i);
            } else {
                toPurge.add(var2.domain.get(i));
                continue;
            }

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if (!var1.domainContains(neededValue)) {
                toPurge.add(var2.domain.get(i));
                revised = true;
            }
        }

        if (toPurge.size() > 0) {
            var2.purgeValue(toPurge);
        }

        return revised;
    }


    /**
     * Revises the subtraction constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseSubtraction(Constraint c1){
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue1 = c1.getArithSol()+var1.domain.get(i);
            int neededValue2 = c1.getArithSol()+var2.domain.get(i);
            if(!var2.domainContains(neededValue1)){
                var1.domain.remove(i);
                revised = true;
            }
            if(!var2.domainContains(neededValue2)){
                var1.domain.remove(i);
                revised = true;
            }
        }

        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue1 = c1.getArithSol()+var1.domain.get(i);
            int neededValue2 = c1.getArithSol()+var2.domain.get(i);
            if(!var1.domainContains(neededValue1)){
                var1.domain.remove(i);
                revised = true;
            }
            if(!var1.domainContains(neededValue2)){
                var2.domain.remove(i);
                revised = true;
            }
        }
        return revised;
    }

    /**
     * Revises the division constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseDivision(Constraint c1){
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue1 = c1.getArithSol()*var1.domain.get(i);
            int neededValue2 = c1.getArithSol()*var2.domain.get(i);
            if(!var2.domainContains(neededValue1)){
                var1.domain.remove(i);
                revised = true;
            }
            if(!var2.domainContains(neededValue2)){
                var1.domain.remove(i);
                revised = true;
            }
        }

        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue1 = c1.getArithSol()*var1.domain.get(i);
            int neededValue2 = c1.getArithSol()*var2.domain.get(i);
            if(!var1.domainContains(neededValue1)){
                var1.domain.remove(i);
                revised = true;
            }
            if(!var1.domainContains(neededValue2)){
                var2.domain.remove(i);
                revised = true;
            }
        }
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
     * getter for constraint list
     * @return - the list
     */
    public ArrayList<Constraint> getConstraintList() {
        return constraintList;
    }

    public void printConstr(ArrayList<Constraint> list){
        for(int i = 0; i < list.size(); i ++){
            //System.out.println(list.get(i).toString());
        }

    }

    public boolean isAssigned(int row, int col){
        return variablesTotal[row][col].isAssigned();
    }

    public int returnAssignment(int row, int col){
        return variablesTotal[row][col].getAssignment();
    }

    public String getDomainAt(int row, int col){
        return variablesTotal[row][col].domainToString();
    }
}
