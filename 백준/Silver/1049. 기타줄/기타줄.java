import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int piece6=1001, piece=1001;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            piece6 = Math.min(piece6, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        if (piece*6<piece6) {
            System.out.println(piece*N);
            return;
        }

        int total = piece6*(N/6);
        total += Math.min(N%6*piece, piece6);
        System.out.println(total);
    }
}