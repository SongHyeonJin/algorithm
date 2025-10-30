import java.io.*;
import java.util.*;
public class Main{
    static int MOD = 15746;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[1000001];
        
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=N ; i++){
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }
        
        System.out.println(dp[N]);
        
    }
}