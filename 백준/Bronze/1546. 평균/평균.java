import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double[] nums = new double[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<nums.length; i++){
            nums[i] = Double.parseDouble(st.nextToken());
        }
        double sum = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            sum += ((nums[i]/nums[nums.length-1])*100);
        }
        System.out.println(sum/ nums.length);
    }
}