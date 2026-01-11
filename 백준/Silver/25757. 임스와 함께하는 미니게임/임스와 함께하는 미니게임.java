import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<String> set = new HashSet<>();
        String[] arr = br.readLine().split(" ");
        int count = Integer.parseInt(arr[0]);
        int playableCount = getPlayableCount(arr[1]);

        for (int i = 0; i < count; i++) {
            String name = br.readLine();
            set.add(name);
        }

        int result = combination(set.size(), playableCount);
        
        System.out.println(result);
    }

    private static int combination(int i, int playableCount) {
        return Math.floorDiv(i,playableCount -1);
    }

    private static int getPlayableCount(String s) {
        if ("Y".equals(s)) {
            return 2;
        }
        if ("F".equals(s)) {
            return 3;
        }
        return 4;
    }
}