import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<int[]> inputs = new ArrayList<>();
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            inputs.add(new int[]{x, y});
            X[i] = x;
            Y[i] = y;
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int x1 = X[x];
                int y1 = Y[y];

                List<Integer> list = new ArrayList<>();
                for (int[] input : inputs) {
                    int x2 = input[0];
                    int y2 = input[1];

                    int disX = Math.abs(x1-x2);
                    int disY = Math.abs(y1-y2);
                    list.add(disX+disY);
                }
                list.sort(Comparator.naturalOrder());
                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += list.get(i);
                    distance[i] = Math.min(distance[i], sum);
                }
            }
        }
        for (int i : distance)
            System.out.print(i+" ");
    }
}