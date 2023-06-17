import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int answer = 0;
            int start = 0;
            int end = n-1;
            int num = Integer.parseInt(st.nextToken());
            while (start <= end){
                int mid = (start+end) / 2;
                if(nums[mid]==num){
                    answer = 1;
                    break;
                }
                if(nums[mid] > num) end  = mid - 1;
                else start = mid + 1;
            }
            System.out.println(answer);
        }
    }
}