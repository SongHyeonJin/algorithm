import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        String star = "*";
        String stars = "";
        for(int i=1; i<=A; i++){
            stars += star;
            System.out.println(stars);
        }
    }
}