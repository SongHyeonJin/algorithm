import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if(gcd(arr[i], arr[i+1]) != 1){
                count += checkGcd(arr[i], arr[i+1]);
            }
        }
        System.out.println(count);
    }
    static int gcd(int a, int b){
        return a%b == 0 ? b : gcd(b, a%b);
    }
    static int checkGcd(int a, int b){
        for (int i = a+1; i < b; i++) {
            if(gcd(a, i) == 1 && gcd(i, b) == 1) return 1;
        }
        return 2;
    }
}