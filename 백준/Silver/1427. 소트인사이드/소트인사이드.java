import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] nums = new int[str.length()];

        for (int i = 0; i < str.length(); i++)
            nums[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        Arrays.sort(nums);

        String num = "";
        for (int i = nums.length-1; i >= 0; i--)
            num += nums[i];
        System.out.println(Integer.parseInt(num));
    }
}