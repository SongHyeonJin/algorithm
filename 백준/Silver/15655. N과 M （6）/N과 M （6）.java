import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] arr, input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[n];
        visited = new boolean[n];
        arr = new int[m];
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0, 0);
        System.out.println(sb);
    }
    static void dfs(int depth, int start){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth+1, i);
                visited[i] = false;
            }
        }
    }
}