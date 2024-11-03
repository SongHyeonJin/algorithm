import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        String[] nums = String.valueOf(b).split("");
        for (int i=nums.length-1; i>=0; i--){
            int mul = a*Integer.parseInt(nums[i]);
            sb.append(mul).append("\n");
        }
        sb.append(a*b);
        System.out.println(sb.toString());
    }
}