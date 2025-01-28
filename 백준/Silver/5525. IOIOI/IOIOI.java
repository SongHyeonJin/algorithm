import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        String pn = pn(n);

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int cnt=0;
            if (s[i]==pn.charAt(0)) {
                cnt++;
                for (int j = 1; j < pn.length(); j++) {
                    if (i+j<s.length)
                        if (s[i+j]==pn.charAt(j)) cnt++;
                }
            }
            if (cnt==pn.length()) answer++;
        }
        System.out.println(answer);
    }
    static String pn(int n) {
        String s = "I";
        return s+"OI".repeat(n);
    }
}