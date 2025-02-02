import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, targetLen, signLen, cnt;
    static String target, sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        target = br.readLine();
        targetLen = target.length();

        while (n > 0) {
            sign = br.readLine();
            signLen = sign.length();
            for (int i = 1; i <= signLen/(targetLen-1); i++) {
                if (compare(i)) {
                    cnt++;
                    break;
                }
            }
            n--;
        }
        System.out.println(cnt);
    }
    static boolean compare(int distance) {
        for (int i = 0; i < signLen-targetLen+1; i++) {
            int idx = i, j;
            for (j = 0; j < targetLen && idx < signLen; j++, idx += distance) {
                if (target.charAt(j) != sign.charAt(idx)) break;
            }
            if (j==targetLen) return true;
        }
        return false;
    }
}
