
import javax.swing.*;
import java.io.File;

/**
 * Created by Josh on 3/2/2016.
 */
public class KenKenWindow extends JFrame{
    private int win_wid = 600;
    private int win_hei = 600;
    private KenKenPuzzle puzzle;
    private File file;
    private KenKenDisplay display;


    public KenKenWindow(){
        this.setTitle("Puzzle Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(win_wid, win_hei);

        //puzzle = new KenKenPuzzle(getFile());
        //display = new KenKenDisplay(puzzle);

        buildMenu();
        //this.add(display);

        this.setVisible(true);
    }

    public void buildMenu(){

        JMenuBar mBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem load = new JMenuItem("Load File");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem withCon = new JMenuItem("Solve with consistency");
        JMenuItem noCon = new JMenuItem("Solve without consistency");

        mBar.add(menu);
        menu.add(load);
        menu.add(withCon);
        menu.add(noCon);
        menu.add(quit);

        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file = setFile();
                changeRows();
            }
        });

        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        withCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set code here to solve with consistency
            }
        });

        noCon.addActionListener(new java.awt.event.ActionListener() {
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

    public void changeRows()
    {
        //this.remove(display);
        puzzle = new KenKenPuzzle(getFile());
        display = new KenKenDisplay(puzzle);
        this.add(display);
        repaint();

    }

    public File getFile() {
        return file;
    }

    public int getWin_wid() {
        return win_wid;
    }

    public int getWin_hei() {
        return win_hei;
    }

    public KenKenPuzzle getPuzzle() {
        return puzzle;
    }

    public KenKenDisplay getDisplay() {
        return display;
    }
}
