import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer  = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int left=0, right = N-1;
        int min = Integer.MAX_VALUE;
        while (left<right) {
            int sum = Math.abs(arr[left]+arr[right]);

            if (sum < min) {
                min = sum;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (arr[left] + arr[right] >= 0) right--;
            else left++;
        }
        for (long a : answer)
            System.out.print(a+" ");
    }
}
