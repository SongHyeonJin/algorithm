import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, answer=0;
    static char[][] board;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for (int y = 0; y < r; y++) {
            String s = br.readLine();
            for (int x = 0; x < s.length(); x++) {
                board[y][x] = s.charAt(x);
            }
        }

        dfs(0, 0, 1);
        System.out.println(answer);
    }
    static void dfs(int y, int x, int count) {
        answer = Math.max(answer, count);
        set.add(board[y][x]);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0>ny || ny>=r || 0>nx || nx>=c) continue;

            if (!set.contains(board[ny][nx])) {
                dfs(ny, nx, count+1);
            }
        }
        set.remove(board[y][x]);
    }
}
