import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> card = new HashMap<>();

        int maxCount = 0;
        for(int i=0; i<n; i++) {
            long num = Long.parseLong(br.readLine());
            card.put(num, card.getOrDefault(num, 0)+1);
            maxCount = Math.max(maxCount, card.get(num));
        }

        long minCard = Long.MAX_VALUE;
        for (long i : card.keySet()) {
            if (maxCount==card.get(i))
                minCard = Math.min(minCard, i);
        }
        System.out.println(minCard);
    }
}