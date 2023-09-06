import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        while (true){
            String str = br.readLine();
            if(str == null || str.equals("")) break;
            count++;
            if(map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            double value = (double)(map.get(key)*100.0)/count;
            sb.append(key+" "+String.format("%.4f",value)).append("\n");
        }
        System.out.println(sb);
    }
}
