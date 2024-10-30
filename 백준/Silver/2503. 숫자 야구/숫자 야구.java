import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] game;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        game = new int[n][3];
        int count = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            game[i][0] = Integer.parseInt(st.nextToken());
            game[i][1] = Integer.parseInt(st.nextToken());
            game[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 9; i++)
            for (int j = 1; j <= 9; j++)
                for (int k = 1; k <= 9; k++)
                    if(i != j && i != k && j != k)
                        if(sol(i, j, k))
                            count++;
        System.out.println(count);
    }
    static boolean sol(int n1, int n2, int n3){
        int first, second, third, strike, ball;
        for (int i = 0; i < n; i++) {
            strike = 0;
            ball = 0;
            first = game[i][0] / 100;
            second = (game[i][0]%100) / 10;
            third =  game[i][0] % 10;

            if(first==n1) strike++;
            else if(first==n2 || first==n3) ball++;
            if(second==n2) strike++;
            else if (second==n1 || second==n3) ball++;
            if(third==n3) strike++;
            else if (third==n1 || third==n2) ball++;

            if(strike != game[i][1] || ball != game[i][2]) return false;
        }
        return true;
    }
}