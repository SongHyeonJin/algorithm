import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr, result;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            
            if (k == 0) {
                break;
            }
            
            arr = new int[k];
            result = new int[6];
            checked = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            backTracking(0, 0);
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static void backTracking(int depth, int start) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            if (!checked[i]) {
                checked[i] = true;
                result[depth] = arr[i];
                backTracking(depth + 1, i + 1);
                checked[i] = false;
            }
        }
    }
}