import javax.swing.*;

/**
 * Created by Josh on 2/25/2016.
 */
public class PuzzleWindow extends JFrame{
    int win_wid = 600;
    Puzzle puzzle;
    int win_hei = 600;

    int rows = 6;
    int cols = 4;

    PuzzleDisplay display;


    public PuzzleWindow(){
        this.setTitle("Puzzle Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(win_wid, win_hei);

        puzzle = new Puzzle(rows, cols);
        display = new PuzzleDisplay(puzzle);
        initMenu();
        this.add(display);
        this.setVisible(true);
    }

    public void initMenu()
    {
        JMenuBar mBar = new JMenuBar();
        JMenu menu = new JMenu("Size");
        JMenuItem rowItem = new JMenuItem("change rows ...");
        rowItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeRows();
            }
        });

        JMenuItem colItem = new JMenuItem("change cols ...");

        mBar.add(menu);
        menu.add(rowItem);
        menu.add(colItem);

        this.setJMenuBar(mBar);
    }

    public void changeRows()
    {
        System.err.print("menu clicked\n");
        String input = JOptionPane.showInputDialog(null,
                "Enter number of rows (ex: 4)","row entry",1);
        rows = Integer.parseInt(input);
        this.remove(display);
        puzzle = new Puzzle(rows,cols);
        display = new PuzzleDisplay(puzzle);
        this.add(display);
        repaint();

    }




    public static void main(String[] args) {
        new PuzzleWindow();
    }
}
