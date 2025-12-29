import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] fileName = br.readLine().split("\\.");
            String extension = fileName[1];

            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        
    }
}