import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int answer = 0;
        int bucket = 1;

        for (int i = 0; i < J; i++) {
            int drop = Integer.parseInt(br.readLine());

            if (drop >= bucket && drop <= bucket + M - 1) {
                continue;
            }

            if (bucket < drop) {
                while (true) {
                    if (drop >= bucket && drop <= bucket + M - 1) {
                        break;
                    }
                    bucket++;
                    answer++;
                }
            } else {
                while (true) {
                    if (drop >= bucket && drop <= bucket + M - 1) {
                        break;
                    }
                    bucket--;
                    answer++;
                }
            }

        }

        System.out.println(answer);
    }
}