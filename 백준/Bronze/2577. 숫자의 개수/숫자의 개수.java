import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        int[] count = new int[10];
        String result = String.valueOf(num1*num2*num3);
        for(int i=0; i<result.length(); i++){
            count[result.charAt(i)-'0']++;
        }
        for(int i=0; i<count.length; i++){
            System.out.println(count[i]);
        }
    }
}