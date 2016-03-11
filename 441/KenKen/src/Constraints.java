import java.util.ArrayList;

/**
 * Created by Josh on 3/2/2016.
 */
public class Constraints {
    private int arithSol;
    private String arithSym;
    private ArrayList<Variables> variables = new ArrayList<Variables>();


    public Constraints(ArrayList<Variables> variabels, int arithSol, String arithSym) {
        this.variables = variabels;
        this.arithSym = arithSym;
        this.arithSol = arithSol;
    }

    public int getArithSol() {
        return arithSol;
    }

    public String getArithSym() {
        return arithSym;
    }

    public ArrayList<Variables> getPoints() {
        return variables;
    }
}
