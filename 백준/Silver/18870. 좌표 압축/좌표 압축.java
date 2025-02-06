import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, sortArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sortArr = arr.clone();
        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();
        int idx=0;
        for (int i : sortArr) {
            if (!map.containsKey(i)) map.put(i, idx++);
        }

        for (int i : arr)
            sb.append(map.get(i)).append(" ");
        System.out.println(sb);
    }
}