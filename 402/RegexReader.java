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
    public static void main(String[]args) throws FileNotFoundException
    {
        File file = setFile();
        SortedSet<String> ipAdrs = new TreeSet();
        SortedSet<String> getRequests = new TreeSet();
//        Pattern p = Pattern.compile("^([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        try(Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
//            stream.forEach(System.out::println);
//            gotEm = stream.map(p::matcher).filter(Matcher::matches).collect(Collectors.toSet());
//            pattern = Pattern.compile(IPADDRESS_PATTERN);
//            matcher = pattern.matcher("180.76.15.140");
//            System.out.println(matcher.matches());
//            stream.map(p::matcher)
//                    .filter(Matcher::matches).findFirst().ifPresent(matcher-> System.out.println(matcher.group(1)));
        }catch (IOException e){
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(file);
        int count = 0;
        while(scanner.hasNextLine())
        {
//            String line = scanner.nextLine();

//            System.out.println("count: " + count);
//            System.out.println("line: " + line);
//            scanner.findInLine("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})(\"GET([^\"]*)\")(Linux)");

            Pattern p = Pattern.compile("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})(\"GET[^\"]*\")(Linux)");
            String line = scanner.nextLine();
            Matcher m = p.matcher(line);
//            System.out.println(line);
            while(m.find())
            {
                String group = m.group();
                System.out.println("group: " + group);
                if(m.group(3).equals("Linux"))
                {
                    System.out.println(m.group().toString());
                    ipAdrs.add(m.group(1));
                    getRequests.add(m.group(2));
                }
            }
//            scanner.findInLine("(\"GET[^\"]*\")");
//
//            try{
//                MatchResult result = scanner.match();
//                System.out.println("group: " + result.group(1));
////                System.out.println("above the test");
////                if(result.group(2).equals("Linux"))
////                {
////                    System.out.println(result.group().toString());
////                    ipAdrs.add(result.group(1));
////                    getRequests.add(result.group(2));
////                }
////
//            }catch(Exception e){
////                continue;
//                System.out.println("continue");
//            }
//            String line = scanner.nextLine();
//            System.out.println("line: " + line);
            count++;
        }
        System.out.println("Above foreach");
        System.out.println(ipAdrs.size());
        for(Object obj : ipAdrs){
            System.out.println(obj);
        }
        for(Object obj : getRequests){
            System.out.println(obj);
        }
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
}
