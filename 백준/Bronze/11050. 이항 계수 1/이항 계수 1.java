import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = factorial(a) / (factorial(a-b) * factorial(b));
        System.out.println(result);
    }

    public static int factorial(int a){
        if(a <= 1) return 1;
        else return factorial(a-1)*a;
    }
}