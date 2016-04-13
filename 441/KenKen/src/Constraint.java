import java.util.ArrayList;

/**
 * Created by Josh on 3/2/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 *
 *  The Constraint class stores the information for each constraint
 */
public class Constraint {
    private int arithSol;
    private String arithSym;
    private ArrayList<Variable> variables = new ArrayList<Variable>();

    /**
     * This is the constructor for the Constraints
     * @param variabels - ArrayList of Variables(the points in each line)
     * @param arithSol - the solution the Constraints must equate to
     * @param arithSym - the arithmetic symbol that the Constraints must use to equate to the Sol
     */
    public Constraint(ArrayList<Variable> variabels, int arithSol, String arithSym) {
        this.variables = variabels;
        this.arithSym = arithSym;
        this.arithSol = arithSol;
    }

    /**
     * getter for the solution
     * @return - the solution
     */
    public int getArithSol() {
        return arithSol;
    }

    /**
     * getter for the symbol
     * @return - the symbol
     */
    public String getArithSym() {
        return arithSym;
    }

    /**
     * getter for the Variable ArrayList
     * @return - the ArrayList
     */
    public ArrayList<Variable> getPoints() {
        return variables;
    }

    public Variable getVariable(int index){
        return variables.get(index);
    }

    public String toString(){
        String result = "variables length: " + variables.size();
        //result+=("--------------\nVariables: " + variables);
        for(int i = 0; i < variables.size(); i ++){
            result += " " + variables.get(i).row + variables.get(i).col+",";
            //result +=("Variable " + i + " domain: " + variables.get(i).getDomain());
        }
        result+=(" Symbol: " + arithSym);
        result+=(" Solution: " + arithSol);
        return result;
    }

    public int getArity(){
        return variables.size();
    }
}
