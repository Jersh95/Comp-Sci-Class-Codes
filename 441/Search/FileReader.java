import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Josh on 2/14/2016.
 *
 * Purpose:
 *  The purpose of the FileReader class is to scan the user entered file and create the grid.
 *  It creates the grid by adding each line to a Data object
 */
public class FileReader {
    private LinkedList<Data> dataList;
    Scanner fileScan;
    private int numNodes;

    /**
     * Empty FileReader constructor to allow the Menu class create an instance of FileReader
     */
    FileReader(){ }

    /**
     * This method will read the file containing the distances between two given nodes.
     * It will create a new Data object for each line of the file and add this object to the LinkedList.
     * @param file - This is the user defined file
     */
    public void createGraphList(File file){
        try
        {
            fileScan = new Scanner(file);
            dataList = new LinkedList();
            numNodes = Integer.parseInt(fileScan.nextLine());

            String start = "";
            String child = "";
            float distance = 0;

            /*
            * This will read the file and create the Data objects and add it to the dataList
             */
            while(fileScan.hasNext())
            {
                start = fileScan.next();
                child = fileScan.next();
                 distance = Float.parseFloat(fileScan.nextLine());
                Data dataValue = new Data(start, child, distance);
                dataList.add(dataValue);
            }
            fileScan.close();
        }

        /*
        * This will catch a FileNotFoundException and display an error message if the file was not found
         */
        catch (FileNotFoundException e)
        {
            System.out.println("Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * This is a getter for the DataList
     * @return
     */
    public LinkedList<Data> getDataList() {
        return dataList;
    }

    /**
     * This is a getter for the number of nodes
     * @return
     */
    public int getNumNodes() {
        return numNodes;
    }
}
