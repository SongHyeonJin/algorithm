import java.io.*;
import java.util.*;

public class Main {
    static int N, S, answer;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);


        if (S == 0) {
            answer--;
        }
        System.out.println(answer);

    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}