import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] nums = new double[N];
        for(int i=0; i<N; i++){
            nums[i] = Double.parseDouble(br.readLine());
        }

        double max = nums[0];

        for(int i=1; i<N; i++){
            nums[i] = Math.max(nums[i], nums[i-1]*nums[i]);
            max = Math.max(nums[i], max);
        }
        System.out.println(String.format("%.3f", max));
    }
}