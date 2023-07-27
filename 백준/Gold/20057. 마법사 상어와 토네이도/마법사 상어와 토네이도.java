import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, count = 0;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] move = {1, 1, 2, 2};
    static int[][] xSand = {
            {-2, -1, -1, -1, 0, 1, 1, 1, 2},
            {0, 1, 0, -1, 2, 1, 0, - 1, 0},
            {2, 1, 1, 1, 0, -1, -1, -1, -2},
            {0, -1, 0, 1, -2, -1, 0, 1, 0}
    };
    static int[][] ySand = {
            {0, -1, 0, 1, -2, -1, 0, 1, 0},
            {-2, -1, -1, -1, 0, 1, 1, 1, 2},
            {0, 1, 0, -1, 2, 1, 0, -1, 0},
            {2, 1, 1, 1, 0, -1, -1, -1, -2}
    };
    static int[] percent = {2, 10, 7, 1, 5, 10, 7, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        tornado(N / 2, N / 2);

        System.out.println(count);
    }

    private static void tornado(int x, int y) {

        int rotateX = x;
        int rotateY = y;

        while (true) {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < move[d]; i++) {
                    int nx = rotateX + dx[d];
                    int ny = rotateY + dy[d];

                    if (nx < 0 || ny < 0 || N <= nx || N <= ny) return;

                    int sand = map[nx][ny];
                    map[nx][ny] = 0;
                    int spreadTotal = 0;

                    for (int s = 0; s < 9; s++) {
                        int sandX = nx + xSand[d][s];
                        int sandY = ny + ySand[d][s];
                        int spreadAmount = (sand * percent[s]) / 100;

                        if (sandX < 0 || sandY < 0 || N <= sandX || N <= sandY) count += spreadAmount;
                        else map[sandX][sandY] += spreadAmount;

                        spreadTotal += spreadAmount;
                    }

                    int alphaX = nx + dx[d];
                    int alphaY = ny + dy[d];
                    int countAlpha = sand - spreadTotal;

                    if (alphaX < 0 || alphaY < 0 || N <= alphaX || N <= alphaY) count += countAlpha;
                    else map[alphaX][alphaY] += countAlpha;

                    rotateX = nx;
                    rotateY = ny;
                }
            }
            for (int i = 0; i < 4; i++) {
                move[i] += 2;
            }
        }
    }
}
