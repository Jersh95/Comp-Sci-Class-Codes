import javax.swing.*;
import java.io.File;

/**
 * Created by Josh on 3/2/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 */
public class KenKenWindow extends JFrame{
    private int win_wid = 600;
    private int win_hei = 600;
    private KenKenPuzzle puzzle;
    private File file;
    private KenKenDisplay display;

    /**
     * This is the constructor for the window
     */
    public KenKenWindow(){
        this.setTitle("Puzzle Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(win_wid, win_hei);
        buildMenu();
        this.setVisible(true);
    }

    /**
     * this will build the menu bar and buttons for the window
     */
    public void buildMenu(){
        //creating the menu bar instance
        JMenuBar mBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem load = new JMenuItem("Load File");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem withCon = new JMenuItem("Solve with consistency");
        JMenuItem noCon = new JMenuItem("Solve without consistency");

        //adding the menu items to the menu
        mBar.add(menu);
        menu.add(load);
        menu.add(withCon);
        menu.add(noCon);
        menu.add(quit);

        load.addActionListener(new java.awt.event.ActionListener() {
            /**
             * This will set the file and call for the puzzle be properly displayed
             * @param evt - item clicked
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file = setFile();
                changeRows();
            }
        });

        quit.addActionListener(new java.awt.event.ActionListener() {
            /**
             * This will exit the program
             * @param evt - item clicked
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        withCon.addActionListener(new java.awt.event.ActionListener() {
            /**
             * This will solve the puzzle with consistency
             * @param evt - item clicked
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set code here to solve with consistency
            }
        });

        noCon.addActionListener(new java.awt.event.ActionListener() {
            /**
             * This will solve the puzzle without consistency
             * @param evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set code here to solve without consistency
            }
        });

        this.setJMenuBar(mBar);
    }

    /**
     * This method will choose which file the user wishes to save to
     * @return - the file
     */
    public static File setFile()
    {
        JFileChooser chooser;
        try{
            // Get the filename.
            chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status != JFileChooser.APPROVE_OPTION)
            {
                System.out.println("No File Chosen");
                System.exit(0);
            }
            return chooser.getSelectedFile();
        } catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    /**
     * This will paint the user selected puzzle
     */
    public void changeRows()
    {
        //this.remove(display);
        puzzle = new KenKenPuzzle(getFile());
        display = new KenKenDisplay(puzzle);
        this.add(display);
        repaint();
    }

    /**
     * getter for the file
     * @return - the file
     */
    public File getFile() {
        return file;
    }

    /**
     * getter for the window width
     * @return - the width
     */
    public int getWin_wid() {
        return win_wid;
    }

    /**
     * getter for window height
     * @return - the height
     */
    public int getWin_hei() {
        return win_hei;
    }

    /**
     * getter for the puzzle
     * @return - the puzzle
     */
    public KenKenPuzzle getPuzzle() {
        return puzzle;
    }

    /**
     * getter for the display
     * @return - the display
     */
    public KenKenDisplay getDisplay() {
        return display;
    }
}
