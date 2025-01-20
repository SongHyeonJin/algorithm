import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] X = new int[3];
        int[] Y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(X);
        Arrays.sort(Y);

        int x=X[0], y=Y[0];
        int cntX=0, cntY=0;
        for (int i = 1; i < 3; i++) {
            if (x==X[i]) cntX++;
            if (y==Y[i]) cntY++;
        }
        if (cntX==1) x=X[2];
        if (cntY==1) y=Y[2];
        System.out.println(x+" "+y);
    }
}