import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            HashMap<String, Integer> map = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            while (N --> 0){
                String[] type = br.readLine().split(" ");
                map.put(type[1], map.getOrDefault(type[1], 0)+1);
            }
            Iterator<Integer> iterator = map.values().iterator();

            int result = 1;
            while (iterator.hasNext()){
                result *= iterator.next().intValue() + 1;
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}