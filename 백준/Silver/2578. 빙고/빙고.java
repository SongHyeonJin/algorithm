import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[5][5];
    static int count;
    static boolean bingo = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 빙고판 만들기
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] mc = new int[25];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                mc[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<25;i++) {
            for(int j=0;j<5;j++) {
                for(int k=0;k<5;k++) {
                    if(board[j][k] == mc[i]) {
                        //지우기
                        board[j][k] = 0;
                        break;
                    }
                }
            }
            //숫자 하나 0만들고 나서 chkBingo
            chkBingo();
            if(bingo) {
                System.out.println(i+1);
                break;
            }
        }

    }
    static void chkBingo() {
        int cnt = 0;
        int sum = 0;

        //가로
        for(int i=0;i<5;i++) {
            sum = 0;
            for(int j=0;j<5;j++){
                sum += board[i][j];
            }
            if(sum == 0) cnt++;
        }

        //세로
        for(int i=0;i<5;i++) {
            sum = 0;
            for(int j=0;j<5;j++){
                sum += board[j][i];
            }
            if(sum == 0) cnt++;
        }

        // 왼아 -> 오위 대각
        sum = 0;
        for(int i=0;i<3;i++) {
            sum += board[2-i][2+i];
            sum += board[2+i][2-i];
        }
        if(sum ==0) cnt++;

        // 왼위 -> 오아 대각
        sum = 0;
        for(int i=0;i<3;i++) {
            sum += board[2+i][2+i];
            sum += board[2-i][2-i];
        }
        if(sum == 0) cnt++;

        if(cnt>=3)
            bingo = true;
    }
}