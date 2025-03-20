import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            cnt = 0;
            sb.append(isPalindrome(s.toCharArray())).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static int recur(char[] cArr, int left, int right) {
        cnt++;

        if (left >= right) return 1;
        else if (cArr[left] != cArr[right]) return 0;
        else return recur(cArr, left+1, right-1);
    }
    static int isPalindrome(char[] cArr) {
        return recur(cArr, 0, cArr.length-1);
    }
}
