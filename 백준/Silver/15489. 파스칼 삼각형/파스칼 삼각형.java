import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // [1][0] + [1][1] 값을 1로 출력하기 위해서 [0][0] 자리는 0으로 두기 위함.
        int[][] pascal = new int[31][31];

        pascal[1][1] = 1;

        for(int i=2; i<=30; i++){
            for(int j=1; j<=i; j++){
                if(j==0 || j==i) pascal[i][j]=1;
                else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        int sum = 0;
        for(int i=0; i<W; i++){
            for(int j=0; j<=i; j++){
                sum += pascal[R+i][C+j];
            }
        }
        System.out.println(sum);
    }
}