import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int x = Integer.parseInt(br.readLine());
        int n = 0;
        while(n * (n + 1) / 2 < x) {
            n++;
        }
        
        int sum = n * (n + 1) / 2;
        if (n % 2 == 0) sb.append(n - sum + x).append("/").append(sum - x + 1);
        else sb.append(sum - x + 1).append("/").append(n - sum + x);
        
        System.out.println(sb.toString());
    }
}