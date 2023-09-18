import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, num;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int row = 0;
        int col =0;

        create();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(map[i][j]).append(" ");
                if(map[i][j] == num){
                    row = i + 1;
                    col = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(row).append(" ").append(col);
        System.out.println(sb);
    }
    static void create(){
        int curRow = n/2;
        int curCol = n/2;
        int next = 0;
        int count = 0;
        int max = 1;
        int rotate = 0;

        for(int i=1; i<=n*n; i++){
            map[curRow][curCol] = i;

            curRow += dx[next%4];
            curCol += dy[next%4];
            count++;
            if(count==max){
                next++;
                count=0;
                rotate++;
            }
            if(rotate==2){
                max++;
                rotate=0;
            }
        }
    }
}
