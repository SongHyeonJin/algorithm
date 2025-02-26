import java.util.*;

class Solution {
    static int answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        map = new int[101][101];
        visited = new boolean[101][101];
        
        for(int i=0; i<rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            draw(2*x1, 2*y1, 2*x2, 2*y2);
        }
        
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        
        return answer;
    }
    static void draw(int x1, int y1, int x2, int y2) {
        for(int x=x1; x<=x2; x++) {
            for(int y=y1; y<=y2; y++) {
                if(map[x][y]==2) continue;
                map[x][y] = 2;
                if(x==x1 || x==x2 || y==y1 || y==y2) map[x][y] = 1;
            }
        }
    }
    static void bfs(int startX, int startY, int endX, int endY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visited[startX][startY] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            
            if(cx==endX && cy==endY) {
                answer = Math.min(answer, map[cx][cy])/2;
                return;
            }
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0|| ny<0 || nx>100 || ny>100) continue;
                if(map[nx][ny]==1 && !visited[nx][ny]) {                    
                    map[nx][ny] = map[cx][cy]+1;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));         
                }                
            }
        }
    }
}