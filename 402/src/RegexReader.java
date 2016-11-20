import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Josh Jacobsen on 10/28/2016.
 */

public class RegexReader
{
    public static SortedSet<String> ipAdrs = new TreeSet();
    public static SortedSet<String> getRequests = new TreeSet();

    public static void main(String[]args) throws FileNotFoundException
    {
        File file = setFile();
        Scanner scanner = new Scanner(file);

        runRegex(scanner, "Linux");
        scanner = new Scanner(file);
        ipAdrs.clear();
        getRequests.clear();
        runRegex(scanner, "Android");
    }

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
    public static void runRegex(Scanner scanner, String literal){
        while(scanner.hasNextLine())
        {
            Pattern p = null;
            if(literal.equals("Linux"))
            {
                p = Pattern.compile("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}).*(GET[^\"]*).*(Linux)");
            }
            else if(literal.equals("Android"))
            {
                p = Pattern.compile("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}).*(GET[^\"]*).*(Android)");
            }

            String line = scanner.nextLine();
            Matcher m = p.matcher(line);
            while(m.find())
            {
                if(m.group(3).equals(literal))
                {
                    ipAdrs.add(m.group(1));
                    getRequests.add(m.group(2));
                }
            }
        }

        System.out.println(literal + " Section's Values: ");
        for(Object obj : ipAdrs){
            System.out.println(obj);
        }
        for(Object obj : getRequests){
            System.out.println(obj);
        }
        scanner.close();
    }
}
