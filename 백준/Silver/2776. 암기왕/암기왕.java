import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int num = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<testCase; i++){
            // 수첩 1
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<N; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }

            // 수첩 2
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                num = Integer.parseInt(st.nextToken());
                if(set.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            set.clear();
        }
        System.out.println(sb.toString());
    }
}
