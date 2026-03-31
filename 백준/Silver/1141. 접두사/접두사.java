import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        Arrays.sort(word, (a, b) -> b.length() - a.length());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean isPrefix = false;
            for (int j = 0; j < i; j++) {
                if (word[j].startsWith(word[i])) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}