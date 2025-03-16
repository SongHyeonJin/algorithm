import java.util.*;

class Solution {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;  i<places.length; i++) {
            answer[i] = 1;
            visited = new boolean[5][5];
            
            for(int y=0; y<places[i].length; y++) {
                for(int x=0; x<places[i][y].length(); x++) {                    
                    if(places[i][y].charAt(x)=='P') {
                        if(!bfs(y, x, visited, places[i])) {
                            answer[i] = 0;
                        }
                    }
                }
            }
        }
        return answer;
    }
    static boolean bfs(int y, int x, boolean[][] visited, String[] place) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, 0});
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            int dis = cur[2];
            
            if(dis==2) continue;
            
            for(int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny<0 || nx<0 || ny>=5 || nx>=5 || visited[ny][nx]) continue;
                
                if(place[ny].charAt(nx)=='X') continue;
                
                if(place[ny].charAt(nx)=='P') {
                    return false;
                }
                
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, dis+1});
            }
        }
        return true;
    }
}