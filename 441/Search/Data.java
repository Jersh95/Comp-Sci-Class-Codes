/**
 * Created by Josh on 2/15/2016.
 *
 * Purpose:
 *  The purpose of this class is to be used to create a grid of nodes which will be a list of objects of this class.
 */
public class Data {
    private String start;
    private String child;
    private float distance;

    /**
     * This is a constructor to create a Data object
     * @param start - the starting node
     * @param child - the starting node's child
     * @param distance - the distance between start and child
     */
    public Data(String start, String child, float distance) {
        this.start = start;
        this.child = child;
        this.distance = distance;
    }

    /**
     * This is a getter for the starting node
     * @return - the starting node
     */
    public String getStart() {
        return start;
    }

    /**
     * This is a setter for the start node
     * @param start - the node to set as start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * This is a getter for the child
     * @return - the child node
     */
    public String getChild() {
        return child;
    }

    /**
     * This is a setter for the child
     * @param end - the node to set as child
     */
    public void setChild(String end) {
        this.child = end;
    }

    /**
     * This is a getter for the distance
     * @return - the distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * This is a setter for the distance
     * @param distance - the distance to set
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }
}
