import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char map[][];
    static int boomTime[][];
    static int R, C, N;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char [R][C];
        boomTime = new int [R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'O') {
                    boomTime[i][j] = 1;
                }
            }
        }

        for (int t = 1; t <= N; t++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(boomTime[i][j] > 0)
                        boomTime[i][j]++;

                    if(t > 1 && t % 2 == 0) {
                        if(map[i][j] == '.') {
                            map[i][j] = 'O';
                            boomTime[i][j] = 1;
                        }
                    }else { 
                        if(boomTime[i][j] == 4) {
                            explode(i, j);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void explode(int r, int c) {
        map[r][c] = '.';
        boomTime[r][c] = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if(boomTime[nr][nc] == 3) continue;
            map[nr][nc] = '.';
            boomTime[nr][nc] = 0;
        }
    }
}