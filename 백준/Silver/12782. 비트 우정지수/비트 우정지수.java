import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            String M = st.nextToken();

            int zero = 0;
            int one = 0;
            for(int j=0; j<M.length(); j++){
                if(N.charAt(j) != M.charAt(j)){
                    if(M.charAt(j)=='1') one++;
                    else zero++;
                }
            }
            sb.append(Math.max(zero, one)+"\n");
        }
        System.out.println(sb);
    }
}