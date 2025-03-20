import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        star = new String[3];
        star[0] = "***";
        star[1] = "* *";
        star[2] = "***";

        int size = 3;
        while(size < n) {
            star = writeStars(star, size);
            size *= 3;
        }

        StringBuilder sb = new StringBuilder();
        for(String s : star) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static String[] writeStars(String[] prev, int size) {
        String[] newStar = new String[size * 3];

        for (int i = 0; i < size; i++) {
            newStar[i] = prev[i] + prev[i] + prev[i];
        }

        String spaces = " ".repeat(size);
        for (int i = 0; i < size; i++) {
            newStar[i + size] = prev[i] + spaces + prev[i];
        }

        for (int i = 0; i < size; i++) {
            newStar[i + 2 * size] = prev[i] + prev[i] + prev[i];
        }
        return newStar;
    }
}