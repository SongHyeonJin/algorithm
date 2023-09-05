import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        input = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int count){
        if(count == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }else {
            int before = 0;
            for(int i=0; i<n; i++){
                if(visited[i]) {
                    continue;
                } else if(before != input[i]){
                    visited[i] = true;
                    arr[count] = input[i];
                    before = input[i];
                    dfs(count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}