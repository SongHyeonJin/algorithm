import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] sentence = br.readLine().split(" ");
            for (int j = 0; j < sentence.length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < sentence[j].length(); k++)
                    sb.append(sentence[j].charAt(k));
                answer.append(sb.reverse()).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}