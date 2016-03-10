import java.io.File;
import java.util.Scanner;

/**
 * Created by Josh on 2/14/2016.
 *
 * Purpose:
 *  The purpose of this class is to create the menu for the user to use.
 *  It will give the user the option to enter the start and end nodes, the file to read, perform a Breadth first and a Depth first search
 *  as well as quit the program.
 */
public class Menu extends FileReader {
    private String start;
    private String end;
    private String filename;
    private File file;
    private Scanner scan = new Scanner(System.in);
    Searches searches = new Searches();

    /**
     * This is a constructor that will be used in the Application class to run this program
     */
    public Menu (){
        this.start = getStart();
        this.end = getEnd();
        this.filename = getFileName();
        this.file = getFile();
        String input;


        /*
        * This is displaying the menu that will display
        * The menu will continue to display until either the user enters 'q' or the program runs a search
         */
        do{
            String menuString = "Press 'S' to enter the start city:   " + start + "\n" +
                    "Press 'E' to enter the end city:   " + end + "\n" +
                    "Press 'F' to enter the desired file:   " + file + "\n\n" +
                    "Press 'B' to do a Breadth First Search:   \n" +
                    "Press 'D' to do a Depth First Search:   \n" +
                    "Press 'Q' to quit the program";
            System.out.println(menuString);
            input = scan.nextLine();
            menuChoice(input);
        }while(!input.equalsIgnoreCase("q"));
    }

    /**
     * This is a switch class that will take the user input and return the appropriate action
     * @param input - the user entered value
     */
    private void menuChoice(String input) {
        switch (input.toLowerCase().charAt(0)) {
            /*
            * If 's' is entered it will set the starting node to the following user entered value
             */
            case 's':
                System.out.println("The start city will be: ");
                setStart(scan.nextLine());
                break;
            /*
            * If 'e' is entered it will set the ending node to the following user entered value
             */
            case 'e':
                System.out.println("The end city will be: ");
                setEnd(scan.nextLine());
                break;
            /*
            * If 'f' is entered it will set the file to the following user entered value
             */
            case 'f':
                System.out.println("The file will be: ");
                String filename = scan.nextLine();

                setFile(filename);
                break;
            /*
            * If 'b' is entered the program will perform a breadth first search based on the values entered
             */
            case 'b':
                createGraphList(getFile());
                System.out.println("\n\nA path from " + getStart().toUpperCase() + " to " + getEnd().toUpperCase() + " is as follows: " + searches.breadthSearch(getDataList(),getStart(),getEnd()).toUpperCase());
                System.out.println("The program will now terminate.");
                System.exit(0);
                //break;
            /*
            * if 'd' is entered the program will perform a depth first search based on the values entered
             */
            case 'd':
                createGraphList(getFile());
                System.out.println("\n\nA path from " + getStart().toUpperCase() + " to " + getEnd().toUpperCase() + " is as follows: " + searches.depthSearch(getDataList(),getStart(),getEnd()).toUpperCase());
                System.exit(0);
                //break;
            /*
            * If 'q' is entered the program will terminate
             */
            case 'q':
                System.out.println("The program will now terminate.");
                System.exit(0);
                //break;
            default:
                break;
        }
    }

    /**
     * This is a getter for the file name
     * @return - the file name
     */
    public String getFileName() {
        return filename;
    }

    /**
     * This is a getter for the File
     * @return - the File
     */
    public File getFile(){return file;}

    /**
     * This is a setter for the File
     * @param fileName - the file name
     */
    public void setFile(String fileName) {
        this.filename = fileName;
        try{
            this.file = new File(filename);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This is a getter for the starting node
     * @return - starting node
     */
    public String getStart() {
        return start;
    }

    /**
     * This is a setter for the starting node
     * @param start - the node to set as start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * This is a getter for the ending node
     * @return - the end node
     */
    public String getEnd() {
        return end;
    }

    /**
     * This is a setter for the ending node
     * @param end - the node to set as end
     */
    public void setEnd(String end) {
        this.end = end;
    }


}



