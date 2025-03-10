import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n-1; i++)
            pq.offer(arr[i+1]-arr[i]);

        int answer=0;
        for (int i = 0; i < n-k; i++)
            answer += pq.poll();
        System.out.println(answer);
    }
}