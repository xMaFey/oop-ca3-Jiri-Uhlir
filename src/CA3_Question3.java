import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */

public class CA3_Question3
{
    static Map<String, HashSet<Integer>> map = new TreeMap<>();

    public static void readFile(String CA3_Question1)
    {
        //Map<String, HashSet<Integer>> map = new TreeMap<>();

        if(map.containsKey(token)){
            map.get(token).add(lineNumber);
        } else{
            HashSet<Integer> set = new HashSet<>();
            set.add(lineNumber);
            map.put(token, set);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
