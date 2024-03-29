import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int i = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(p == 0 && l == 0 && v == 0) break;
            int total = l * (v/p) + Math.min(l, v%p);
            sb.append("Case "+ i + ": "+total).append("\n");
            i++;
        }
        System.out.println(sb);
    }
}