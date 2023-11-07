import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int a = 300;
        int b = 60;
        int c = 10;

        sb.append(t/a+" ");
        t %= a;
        sb.append(t/b+" ");
        t %= b;
        sb.append(t/c);
        if (t%c == 0)
            System.out.println(sb);
        else
            System.out.println(-1);
    }
}