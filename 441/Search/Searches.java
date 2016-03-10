import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Josh Jacobsen on 2/21/2016.
 *
 * Purpose:
 *  The purpose of the Searches class is to perform the Breadth first and Depth first searches of the user entered start and end positions
 *  as well as the file.
 *
 */
public class Searches {
    private ArrayList<String> frontier = new ArrayList<String>();
    private ArrayList<String> explored = new ArrayList<String>();

    /**
     * Empty Searches constructor that allows the Menu class to create an instance of Searches
     */
    public Searches(){ }

    /**
     * This will perform the Breadth first search of the user entered start and end positions as well as the file.
     * My algorithm for adding to the frontier is by taking the children from the given parent in the order that they
     * are listed in the file, I am not adding them in alphabetical order.
     * @param dataList - The ArrayList that is holding the grid read from the file
     * @param start - The starting node
     * @param end - The ending node
     * @return - A string representation of a path from start to end
     */
    protected String breadthSearch(LinkedList<Data> dataList, String start, String end){
        String path = "";
        frontier.add(start);
        boolean pathFound = false;
        boolean doesContain;
        boolean endLoop = false;
        float distance = 0;
        /*
        * This do loop will perform the search as long as the path has not been found or the frontier becomes empty
        * which would mean that a path is not possible
         */
        do{
            /*
            * This is checking if the frontier is empty and quitting if if is
             */
            if(frontier.size() == 0)
            {
                pathFound = false;
                System.out.println("The search failed to find a solution.");
                break;
            }

            /*
            * This is checking if the first node in the frontier has already been explored
            * if it has it will be removed from the frontier
             */
            do {
                if (explored.contains(frontier.get(0))) {
                    frontier.remove(frontier.get(0));
                    doesContain = true;
                }
                else
                    doesContain = false;
            }while (doesContain == true);

            /*
            * This is double checking that the explored does not contain the first item on the frontier
            * if it does not then it will add the first item from the frontier to the explored and remove the
            * first item from the frontier
             */
            if(!explored.contains(frontier.get(0))){
                System.out.println("----------");
                System.out.println("Frontier:");
                for(int f = 0; f < frontier.size(); f++){
                    System.out.println(frontier.get(f).toUpperCase());
                }
                System.out.println("Explored:");
                for(int e = 0; e < explored.size(); e++){
                    System.out.println(explored.get(e).toUpperCase());
                }

                explored.add(frontier.get(0));
                frontier.remove(frontier.get(0));

                /*
                * This will explore the last item on the explored list and add child nodes of the current node to the frontier
                 */
                for(int i = 0; i < dataList.size(); i ++){
                    //System.out.println(i);
                    if(dataList.get(i).getStart().equalsIgnoreCase(explored.get(explored.size()-1))){
                        frontier.add(dataList.get(i).getChild());

                        /*
                        * This is checking if a child node is the end node
                         */
                        if(dataList.get(i).getChild().equalsIgnoreCase(end)){
                            String lastNode = end;
                            path+= lastNode;

                            /*
                            * Once the end node is found, the program will go backwards and find the full path
                            * It will go backwards by finding the end node in the grid and adding it's parent to the path
                            * It will then take the parent's node and find its place in the child section and add that parent to the path
                            * It will do this until the parent node is the start node
                             */
                            do{
                                for(int p = 0; p < dataList.size(); p ++){
                                    if(dataList.get(p).getChild().equalsIgnoreCase(lastNode)){
                                        path = dataList.get(p).getStart() + path;
                                        distance += dataList.get(p).getDistance();
                                        lastNode = dataList.get(p).getStart();

                                        /*
                                        * Once the start node is found, the search will end and return the path
                                         */
                                        if(dataList.get(p).getStart().equalsIgnoreCase(start)){
                                            pathFound = true;
                                            endLoop = true;
                                            path += " with a distance of " + distance;
                                        }
                                    }
                                }
                            }while(endLoop ==false);
                        }
                    }
                }
            }
        }while(pathFound == false);

        return path;
    }

    /**
     * This will perform the Depth first search of the user entered start and end positions as well as the file.
     * My algorithm for adding to the frontier is by taking the children from the given parent in the order that they
     * are listed in the file, I am not adding them in alphabetical order.
     * @param dataList - The ArrayList that is holding the grid read from the file
     * @param start - The starting node
     * @param end - The ending node
     * @return - A string representation of a path from start to end
     */
    protected String depthSearch(LinkedList<Data> dataList, String start, String end){
        String path = "";
        frontier.add(start);
        boolean pathFound = false;
        boolean doesContain;
        boolean endLoop = false;
        float distance = 0;

        /*
        * This do loop will perform the search as long as the path has not been found or the frontier becomes empty
        * which would mean that a path is not possible
         */
        do{
            /*
            * This is checking if the frontier is empty and quitting if if is
             */
            if(frontier.size() == 0)
            {
                pathFound = false;
                System.out.println("The search failed to find a solution.");
                break;
            }

            /*
            * This is checking if the first node in the frontier has already been explored
            * if it has it will be removed from the frontier
             */
            do {
                if (explored.contains(frontier.get(frontier.size()-1))) {
                    frontier.remove(frontier.get(frontier.size()-1));
                    doesContain = true;
                }
                else
                    doesContain = false;
            }while (doesContain == true);

            /*
            * This is double checking that the explored does not contain the first item on the frontier
            * if it does not then it will add the first item from the frontier to the explored and remove the
            * first item from the frontier
             */
            if(!explored.contains(frontier.get(frontier.size()-1))){
                System.out.println("----------");
                System.out.println("Frontier:");
                for(int f = 0; f < frontier.size(); f++){
                    System.out.println(frontier.get(f).toUpperCase());
                }
                System.out.println("Explored:");
                for(int e = 0; e < explored.size(); e++){
                    System.out.println(explored.get(e).toUpperCase());
                }
                explored.add(frontier.get(frontier.size()-1));
                frontier.remove(frontier.get(frontier.size()-1));

                /*
                * This will explore the last item on the explored list and add child nodes of the current node to the frontier
                 */
                for(int i = 0; i < dataList.size(); i ++){
                    if(dataList.get(i).getStart().equalsIgnoreCase(explored.get(explored.size()-1))){
                        frontier.add(dataList.get(i).getChild());

                        /*
                        * This is checking if a child node is the end node
                         */
                        if(dataList.get(i).getChild().equalsIgnoreCase(end)){
                            String lastNode = end;
                            path+= lastNode;

                            /*
                            * Once the end node is found, the program will go backwards and find the full path
                            * It will go backwards by finding the end node in the grid and adding it's parent to the path
                            * It will then take the parent's node and find its place in the child section and add that parent to the path
                            * It will do this until the parent node is the start node
                             */
                            do{
                                for(int p = 0; p < dataList.size(); p ++){
                                    if(dataList.get(p).getChild().equalsIgnoreCase(lastNode)){
                                        path = dataList.get(p).getStart() + path;
                                        distance += dataList.get(p).getDistance();
                                        lastNode = dataList.get(p).getStart();

                                        /*
                                        * Once the start node is found, the search will end and return the path
                                         */
                                        if(dataList.get(p).getStart().equalsIgnoreCase(start)){
                                            pathFound = true;
                                            endLoop = true;
                                            path += " with a distance of " + distance;
                                        }

                                    }
                                }
                            }while(endLoop ==false);
                        }
                    }
                }
            }
        }while(pathFound == false);

        return path;
    }
}
