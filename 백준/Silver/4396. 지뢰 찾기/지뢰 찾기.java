import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char[][] mine = new char[n][n];
        char[][] mineCnt = new char[n][n];
        int[] dx = {-1,-1,-1,0,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,0,1,-1,0,1};

        for(int i=0; i<n; i++){
            mine[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++){
            mineCnt[i] = br.readLine().toCharArray();
        }

        boolean result = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int cnt = 0;
                if(mineCnt[i][j] == 'x') {
                    if(mine[i][j] == '*') {
                        result = true;
                    }
                    else {
                        for(int k = 0; k < dx.length; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if(x >= 0 && x < n && y >= 0 && y < n && mine[x][y] == '*')cnt++;
                        }
                        mineCnt[i][j] = (char)(cnt + '0');
                    }
                } else mineCnt[i][j] = '.';
            }
        }

        if(result) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mine[i][j] == '*') {
                        mineCnt[i][j] = '*';
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(mineCnt[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}