import java.util.*;

class Solution {
    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        
        return bfs(maps, dist, n, m);
    }
    
    private int bfs(int[][] maps, int[][] dist, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == n - 1 && curr[1] == m - 1) return dist[curr[0]][curr[1]];
            
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && maps[ny][nx] == 1 && dist[ny][nx] == 0) {
                    dist[ny][nx] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{ny, nx});
                }
                
            }
        }
        return -1;
    }
}