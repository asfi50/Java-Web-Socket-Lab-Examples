package intermediate.lab3;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringToArray {
    public static ArrayList<Integer> getArray(String s){
        ArrayList<Integer> arr = new ArrayList<>();
        
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        while(stringTokenizer.hasMoreTokens()){
            arr.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        
        return arr;
    }
}
