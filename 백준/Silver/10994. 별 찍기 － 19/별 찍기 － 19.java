import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int size = 4*(N-1)+1;
        char[][] star = new char[size][size];
        int idx = 0;

        for(int i=0; i<=N; i++){
            for(int j=idx; j<size-idx; j++){
                star[idx][j] = '*'; // 사각형 맨 윗 줄
                star[size-idx-1][j] = '*'; // 사각형 맨 아랫 줄
                star[j][idx] = '*'; // 사각형 맨 왼쪽 줄
                star[j][size-idx-1] = '*'; // 사각형 맨 오른쪽 줄
            }
            idx+=2; // 점점 작은 정사각형 안쪽에 그림
        }
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(star[i][j]=='*') sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}