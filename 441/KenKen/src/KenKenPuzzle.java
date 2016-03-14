import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Josh Jacobsen on 3/2/2016.
 */
public class KenKenPuzzle {
    private String[][] puzzle;
    private int numRows;
    private ArrayList<Constraints> constraintList = new ArrayList<Constraints>();
    private ArrayList<Variables> varList;
    File file;
    private int[][] groupIndex;

    public KenKenPuzzle(File file){
        createPuzzle(file);
        this.file = file;

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

            int constrCount = 0;
            //This will read in the variables
            while (scanner.hasNext()) {
                int sol = 0;
                String sym = "";
                String temp = "";
                varList = new ArrayList<Variables>();
                while (scanner.hasNextInt()) {
                    int row = scanner.nextInt();
                    System.out.println("Row: " + row);
                    int col = scanner.nextInt();
                    System.out.println("Col: " + col);
                    Variables variables = new Variables(row, col, getNumRows());
                    varList.add(variables);
                    varList.get(varList.size()-1).setAssigned(true);

                    groupIndex[row][col] = constrCount;
                    System.out.println("COUNT: " + constrCount);
                    System.out.println("GRID: " + groupIndex[row][col]);
                    System.out.println("---------------");
                }

                //This will read in everything after the last point, the colon, the solution value, and the solution arithmetic symbol
                temp = scanner.nextLine();
                sym = Character.toString(temp.charAt(temp.length() - 1));
                sol = Integer.parseInt(temp.substring(2, temp.length() - 1));

                if(sym.equals("=")){
                    varList.get(varList.size()-1).setAssignment(sol);
                    varList.get(varList.size()-1).setAssigned(true);
                }
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

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public ArrayList<Variables> getVarList() {
        return varList;
    }

    public void setVarList(ArrayList<Variables> varList) {
        this.varList = varList;
    }

    public int[][] getGroupIndex() {
        return groupIndex;
    }

    public int getGoupIndexValue(int row, int col){return groupIndex[row][col];}

    public void setGroupIndex(int[][] groupIndex) {
        this.groupIndex = groupIndex;
    }

    public ArrayList<Constraints> getConstraintList() {
        return constraintList;
    }

    public void setConstraintList(ArrayList<Constraints> constraintList) {
        this.constraintList = constraintList;
    }


}
