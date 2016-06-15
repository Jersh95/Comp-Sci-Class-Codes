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
                Constraint constraint = new Constraint(varList, sol, sym);
                this.constraintList.add(constraint);
                constrCount++;
            }

            formInequality();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will generate the next arc constency step once the user clicks the screen
     */
    public void generateMove() {

        //If node consistency hasn't been run yet, run it
        for(int row = 0; row < variablesTotal.length; row++) {
            for(int col = 0; col < variablesTotal[row].length; col++) {
            }
        }

        //Run arc consistency only after node consistency has been run once first
        if (isNoded == false){
            nodeConsistency(constraintList);
            for(int row = 0; row < variablesTotal.length; row++) {
                for (int col = 0; col < variablesTotal[row].length; col++) {
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
                Variable curVar =  list.get(i).getPoints().get(0);
                int val = list.get(i).getArithSol();
                curVar.setAssignment(val);
                curVar.setAssigned(true);
                curVar.setSingleton(val);
            }
        }
        isNoded = true;
    }

    /**
     * Forms the inequality constraints and adds it to the total constraint list
     */
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
                    }
                }
            }
        }

        for(int col = 0; col < numRows; col++){
            for(int var = 0; var < numRows; var++){
                for(int row = 0; row < numRows; row++){
                    if(var != col) {
                        Variable var1 = variablesTotal[var][col];
                        Variable var2 = variablesTotal[row][col];
                        ArrayList<Variable> conVars = new ArrayList<Variable>();
                        conVars.add(var1);
                        conVars.add(var2);
                        Constraint constr = new Constraint(conVars, 0, "!=");
                        constraintList.add(constr);
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
        Stack queue = new Stack();
        boolean revised = false;
        String constrType = "";

        //Add all constraints to the queue
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getArity() == 2) {
                queue.push(list.get(i));
            }
        }

        //Pop the top constraint off in order to evaluate it
        while (queue.size()>0){
            Constraint topConstr = (Constraint) queue.pop();
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
            case "+": reviseAddition(c1);
                revised = true;
                break;
            case "-": reviseSubtraction(c1);
                revised = true;
                break;
            case "x": reviseMultiplication(c1);
                revised = true;
                break;
            case "/": reviseDivision(c1);
                revised = true;
                break;
            case "!=": reviseInequality(c1);
                revised = true;
                break;
            default:
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
        boolean revised = false;
        ArrayList<Integer> toPurge = new ArrayList<>();

        //check if var1 is assigned
        if(var1.isAssigned()) {

            //if it is then remove its value from var2's domain
            revised = var2.removeDomValue(var1.getAssignment());
            if (revised) {
                var2.checkForSingleton();
            }
        }

        //check if var2 is assigned
        if(var2.isAssigned()){
            //if it is then remove its value from var1's domain
            revised = var1.removeDomValue(var2.getAssignment());
            if(revised){
                var1.checkForSingleton();
            }
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

        for(int i = 0; i < var1.domain.size(); i++){

            //loop through the domain of the variable and test the domains against the needed value
            int neededValue = c1.getArithSol()-var1.domain.get(i);

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if(!var2.domainContains(neededValue)){
                toPurge.add(var1.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if (toPurge.size() > 0) {
            var2.purgeValue(toPurge);
            var2.checkForSingleton();
        }

        toPurge = new ArrayList<>();

        for(int i = 0; i < var2.domain.size(); i++){

            //loop through the domain of the variable and test the domains against the needed value
            int neededValue = c1.getArithSol()-var2.domain.get(i);

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if(!var1.domainContains(neededValue)){
                toPurge.add(var2.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
            var1.checkForSingleton();
        }
        return revised;
    }

    /**
     * Revises the multiplication constraints
     * @param c1 - the Constraint
     * @return - true if it was revised
     */
    public boolean reviseMultiplication(Constraint c1) {
        Variable var1 = c1.getVariable(0);
        Variable var2 = c1.getVariable(1);
        boolean revised = false;
        ArrayList<Integer> toPurge = new ArrayList<>();

        for (int i = 0; i < var1.domain.size(); i++) {
            int neededValue = 0;

            //loop through the domain of the variable and test the domains against the needed value
            if (c1.getArithSol() % var1.domain.get(i) == 0) {
                neededValue = c1.getArithSol() / var1.domain.get(i);
            } else {
                toPurge.add(var1.domain.get(i));
                continue;
            }

            //if the domain doesn't contain the needed value then remove it and set revise to true
            if (!var2.domainContains(neededValue)) {
                toPurge.add(var1.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if (toPurge.size() > 0) {
            var1.purgeValue(toPurge);
            var1.checkForSingleton();
        }

        toPurge = new ArrayList<>();

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

        //Purge the bad domain values
        if (toPurge.size() > 0) {
            var2.purgeValue(toPurge);
            var2.checkForSingleton();
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
        ArrayList<Integer> toPurge = new ArrayList<>();

        //loop through the domain of the variable and test the domains against the needed value
        for(int i = 0; i < var1.domain.size(); i++){
            int neededValue1 = c1.getArithSol()+var1.domain.get(i);
            int neededValue2 = var1.domain.get(i)-c1.getArithSol();
            if(var2.domain.contains(neededValue1) || var2.domain.contains(neededValue2)){
            }
            else{
                toPurge.add(var1.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if(toPurge.size()>0){
            var1.purgeValue(toPurge);
            var1.checkForSingleton();
        }
        toPurge = new ArrayList<>();

        //loop through the domain of the variable and test the domains against the needed value
        for(int i = 0; i < var2.domain.size(); i++){
            int neededValue1 = c1.getArithSol()+var2.domain.get(i);
            int neededValue2 = var2.domain.get(i)-c1.getArithSol();
            if(var1.domain.contains(neededValue1) || var1.domain.contains(neededValue2)){
            }
            else{
                toPurge.add(var2.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if(toPurge.size()>0){
            var2.purgeValue(toPurge);
            var2.checkForSingleton();
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
        ArrayList<Integer> toPurge = new ArrayList<>();
        int neededValue1 = 0;
        int neededValue2 = 0;

        //loop through the domain of the variable and test the domains against the needed value
        for(int i = 0; i < var1.domain.size(); i++){
            neededValue1 = c1.getArithSol() * var1.domain.get(i);
            neededValue2 = var1.domain.get(i) / c1.getArithSol();

            if(!var2.domain.contains(neededValue1) && !(var1.domain.get(i) % c1.getArithSol() == 0 && var2.domain.contains(neededValue2))){
                toPurge.add(var1.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if(toPurge.size()>0){
            var1.purgeValue(toPurge);
            var1.checkForSingleton();
        }
        toPurge = new ArrayList<>();

        //loop through the domain of the variable and test the domains against the needed value
        for(int i = 0; i < var2.domain.size(); i++){
            neededValue1 = c1.getArithSol() * var2.domain.get(i);
            neededValue2 = var2.domain.get(i) / c1.getArithSol();

            if(!var1.domain.contains(neededValue1) && !(var2.domain.get(i) % c1.getArithSol() == 0 && var1.domain.contains(neededValue2))){
                toPurge.add(var2.domain.get(i));
                revised = true;
            }
        }

        //Purge the bad domain values
        if(toPurge.size()>0){
            var2.purgeValue(toPurge);
            var2.checkForSingleton();
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

    /**
     * Checks if the specific cell is assigned
     * @param row - the row
     * @param col - the col
     * @return - if the cell is assigned or not
     */
    public boolean isAssigned(int row, int col){
        return variablesTotal[row][col].isAssigned();
    }

    /**
     * Gets the assignment of a specified cell
     * @param row - the row
     * @param col - the col
     * @return - the assignment of the cell
     */
    public int returnAssignment(int row, int col){
        return variablesTotal[row][col].getAssignment();
    }

    /**
     * Gets the domain list of a specified cell
     * @param row - the row
     * @param col - the col
     * @return - the domain list
     */
    public String getDomainAt(int row, int col){
        return variablesTotal[row][col].domainToString();
    }
}
