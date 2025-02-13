import java.util.*;

class Solution {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] graph;
    static Queue<int[]> q = new LinkedList<>();
    public int solution(int[][] maps) {
        int y = maps.length;
        int x = maps[0].length;
        graph = new int[y][x];
        bfs(maps);
        return graph[y-1][x-1]==0 ? -1 : graph[y-1][x-1];
    }
    static void bfs(int[][] maps){
        graph[0][0] = 1;
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0>ny || ny>=maps.length || 0>nx || nx>=maps[0].length) continue;
                
                if(graph[ny][nx]==0 && maps[ny][nx]==1) {
                    graph[ny][nx] = graph[y][x] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}