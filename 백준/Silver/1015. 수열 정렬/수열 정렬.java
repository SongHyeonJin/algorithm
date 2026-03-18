import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] flag = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }

        Arrays.sort(B);

        for(int i = 0 ; i < N ; i ++){
            for (int j = 0; j < N; j++) {
                if (flag[j] || A[i] != B[j]) continue;

                flag[j] = true;
                sb.append(j).append(" ");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}