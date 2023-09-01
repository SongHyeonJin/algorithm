import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = 0;
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(nums[i], max);
        }
        int[] isPrime = new int[max+1];
        isPrime[1] = 1;
        long answer = 1;
        for(int i=2; i*i<isPrime.length; i++){
            if(isPrime[i] == 1) continue;
            for(int j=i*2; j<isPrime.length; j+=i){
                isPrime[j] = 1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(isPrime[nums[i]] == 1) continue;
            answer *= nums[i];
            isPrime[nums[i]] = 1;
        }
        System.out.println(answer == 1 ? -1 : answer);
    }
}
