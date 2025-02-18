import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        star = new String[n];

        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        for (int i = 1; 3*Math.pow(2, i) <= n; i++) {
            writeStar(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(star[i]);
        }
    }
    static void writeStar(int i) {
        int bottom = (int) (3*Math.pow(2, i));
        int middle = bottom/2;
        for (int j = middle; j < bottom; j++) {
            star[j] = star[j-middle]+" "+star[j-middle];
        }
        String black = " ".repeat(middle);
        for (int j = 0; j < middle; j++) {
            star[j] = black + star[j] + black;
        }
    }
}