import java.util.TreeMap;

public class MemoryManager
{
    TreeMap<Integer, Area> free;
    TreeMap<Integer, Area> used;

    public MemoryManager(int size)
    {

        free = new TreeMap<Integer, Area>();
        used = new TreeMap<Integer, Area>();
        free.put(0, new Area(0, size));
    }

    public Area aquire(int amount)
    {

        return null;
    }

    public void release(int handle)
    {

    }

    public void print()
    {
        synchronized (free)
        {
            System.out.println("\nFree");
            free.forEach((k, v) -> System.out.println(k + "->" + v.getEnd() + "(" + v.getSize() + ")"));
            System.out.println("Used");
            used.forEach((k, v) -> System.out.println(k + "->" + v.getEnd() + "(" + v.getSize() + ")"));
        }
    }

    public Area getFirstFree()
    {
        return free.firstEntry().getValue();
    }

}
