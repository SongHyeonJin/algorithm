import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++){
                if(!visited[i]){
                    dfs(arr[i]);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int start){
        visited[start] = true;

        int next = arr[start];
        if(!visited[next]) dfs(next);
    }
}