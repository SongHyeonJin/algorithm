import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n+1];
        int[] answer = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            line[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            int j=1;
            while (true) {
                if (line[i]==0 && answer[j]==0) {
                    answer[j] = i;
                    break;
                }
                else if (answer[j]==0) line[i]--;
                j++;
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.print(answer[i]+" ");
    }
}
