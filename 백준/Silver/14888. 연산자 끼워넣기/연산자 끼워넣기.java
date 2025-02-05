import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, operation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operation = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            operation[i] = Integer.parseInt(st.nextToken());
        
        sol(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    static void sol(int num, int idx) {
        if (idx==n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i]>0) {
                operation[i]--;
                switch (i) {
                    case 0:
                        sol(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        sol(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        sol(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        sol(num / arr[idx], idx + 1);
                        break;
                }
                operation[i]++;
            }
        }
    }
}
