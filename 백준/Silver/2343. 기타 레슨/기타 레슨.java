import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int left=0, right=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while (left<=right) {
            int mid = (left+right)/2;

            int count = 1;
            int sum = arr[0];
            for (int i = 1; i < N; i++) {
                if (sum+arr[i] > mid){
                    count++;
                    sum = arr[i];
                } else sum += arr[i];
            }
            if (count>M) left = mid+1;
            else right = mid-1;
        }
        System.out.println(left);
    }
}