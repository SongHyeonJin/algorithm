import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int num = 0;
        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);
        for(int i=1; i<N; i++){
            num = Integer.parseInt(nums[i]);
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        System.out.print(min);
        System.out.println(" "+max);
    }
}