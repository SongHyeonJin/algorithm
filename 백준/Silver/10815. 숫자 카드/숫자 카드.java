import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr2.length; i++) {
            int s=0;
            int e=n-1;
            boolean flag = false;

            while (s<=e){
                int mid = (s+e)/2;

                if (arr1[mid] == arr2[i]){
                    flag = true;
                    break;
                } else if (arr1[mid] > arr2[i]) e = mid-1;
                else if (arr1[mid] < arr2[i]) s = mid+1;
            }
            if (flag) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}