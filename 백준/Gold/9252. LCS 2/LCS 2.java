import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static char[] str1, str2;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 =  br.readLine().toCharArray();
        int oneLen = str1.length;
        int twoLen = str2.length;
        dp = new int[oneLen+1][twoLen+1];

        for (int i = 1; i <= oneLen; i++) {
            for (int j = 1; j <= twoLen; j++) {
                if (str1[i-1]==str2[j-1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        sb.append(dp[oneLen][twoLen]).append("\n");
        lcs(str1, oneLen, twoLen);
        System.out.println(sb);
    }
    static void lcs(char[] str, int i, int j) {
        Stack<Character> stack = new Stack<>();
        while (i>0 && j>0) {
            if (dp[i][j]==dp[i-1][j]) i--;
            else if (dp[i][j]==dp[i][j-1]) j--;
            else {
                stack.push(str[i-1]);
                i--;
                j--;
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
    }
}