import java.util.*;

class Solution {
    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[] start = new int[2], lever = new int[2], exit = new int[2];
        char[][] graph = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
                if (graph[i][j] == 'S') start = new int[]{i, j};
                else if (graph[i][j] == 'L') lever = new int[]{i, j};
                else if (graph[i][j] == 'E') exit = new int[]{i, j};
            }
        }
        
        int toLever = bfs(graph, start, lever, n, m);
        int toExit = bfs(graph, lever, exit, n, m);

        if (toLever == -1 || toExit == -1) return -1;
        return toLever + toExit;
    }
    
    private int bfs(char[][] graph, int[] start, int[] end, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        q.offer(start);
        dist[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == end[0] && curr[1] == end[1]) return dist[curr[0]][curr[1]] - 1;

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (ny >= 0 && ny < n && nx >=0 && nx < m && graph[ny][nx] != 'X' && dist[ny][nx] == 0) {
                    dist[ny][nx] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        return -1;
    }
}