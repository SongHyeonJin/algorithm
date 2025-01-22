import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        int cnt=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]=='P') {
                int startIdx = Math.max(i-k, 0);
                int endIdx = Math.min(i+k, n-1);
                for (int j = startIdx; j <= endIdx; j++) {
                    if (arr[j]=='H'){
                        cnt++;
                        arr[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}