import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int energy = Integer.MAX_VALUE;
    static int [][] jumps;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        jumps = new int[n+1][2];
        int small;
        int big;
        for(int i=1; i<=n-1; i++) {
            String[] s = br.readLine().split(" ");
            small = Integer.parseInt(s[0]);
            big = Integer.parseInt(s[1]);
            jumps[i][0]=small;
            jumps[i][1]=big;
        }
        k = Integer.parseInt(br.readLine());

        dfs(0,1,false);
        System.out.println(energy);
    }

    private static void dfs(int stone, int jump, boolean flag){
        if(jump==n){
            energy = Math.min(energy,stone);
            return;
        }
        if(jump>n) return;

        dfs(stone+jumps[jump][0],jump+1,flag);
        dfs(stone+jumps[jump][1],jump+2,flag);

        if(!flag) dfs(stone+k, jump+3, true);
    }
}