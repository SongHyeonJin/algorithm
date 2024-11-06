import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int count = 0;
            int twoPreNum = 1;
            int preNum = 1;

            while (true) {
                int num = (preNum+twoPreNum)%m;
                twoPreNum = preNum;
                preNum = num;
                count++;

                if(preNum == 1 && twoPreNum == 1) break;
            }
            sb.append(n).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}