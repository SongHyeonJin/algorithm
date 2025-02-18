import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long answer = 1;

        if (a>c) {
            a = a%c;
        }

        while (b!=1) {
            if (b%2==1) {
                answer = (answer*a)%c;
                b--;
            }
            a = (a*a)%c;
            b /= 2;
        }
        answer = (answer*a)%c;
        System.out.println(answer);
    }
}