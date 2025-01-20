import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int cnt = 0;
        if (num < 100) {
            System.out.println(num);
            return;
        }
        else {
            cnt = 99;
            for (int i = 100; i <= num; i++) {
                int hun = i/100;
                int ten = (i/10)%10;
                int one = i%10;

                if ((hun-ten) == (ten-one)) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
