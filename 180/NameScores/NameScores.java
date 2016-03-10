package project_euler_assignments.midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Josh Jacobsen on 2/19/2016.
 */
public class Prob22 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\Fresh\\Desktop\\names.txt")).useDelimiter("[\",]+");
        ArrayList<String> names = new ArrayList<String>();
        while (in.hasNext()) {
            names.add(in.next());
        }
        Collections.sort(names);

        long totalValue = 0;
        long nameValue;
        for(int i = 0; i < names.size(); i++){
            nameValue = 0;
            for(int j = 0; j < names.get(i).length();j++){
                nameValue += getValue(names.get(i).charAt(j));
            }
            totalValue += nameValue*(i+1);
            System.out.println("Name: " + names.get(i) + "    Value: " + nameValue + "    index: " + i  + "    Total Value: " + totalValue);
        }
        System.out.println(totalValue);


    }

    public static int getValue(char c) {
        int value = 0;

        switch (Character.toLowerCase(c)) {
            case 'a':
                value = 1;
                break;
            case 'b':
                value = 2;
                break;
            case 'c':
                value = 3;
                break;
            case 'd':
                value = 4;
                break;
            case 'e':
                value = 5;
                break;
            case 'f':
                value = 6;
                break;
            case 'g':
                value = 7;
                break;
            case 'h':
                value = 8;
                break;
            case 'i':
                value = 9;
                break;
            case 'j':
                value = 10;
                break;
            case 'k':
                value = 11;
                break;
            case 'l':
                value = 12;
                break;
            case 'm':
                value = 13;
                break;
            case 'n':
                value = 14;
                break;
            case 'o':
                value = 15;
                break;
            case 'p':
                value = 16;
                break;
            case 'q':
                value = 17;
                break;
            case 'r':
                value = 18;
                break;
            case 's':
                value = 19;
                break;
            case 't':
                value = 20;
                break;
            case 'u':
                value = 21;
                break;
            case 'v':
                value = 22;
                break;
            case 'w':
                value = 23;
                break;
            case 'x':
                value = 24;
                break;
            case 'y':
                value = 25;
                break;
            case 'z':
                value = 26;
                break;
        }
        return value;
    }
}
