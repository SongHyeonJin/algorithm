import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        recur(0);
        System.out.println(sb);
    }

    static void recur(int num){
        if (num == m){
            for (int val : arr)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }
        for (int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[num] = i+1;
                recur(num+1);
                visited[i] = false;
            }
        }
    }
}
