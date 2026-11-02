class Solution {
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};
    boolean[][][] visited;
    public int solution(String dirs) {
        int y = 5;
        int x = 5;
        int dir = -1;
        int distance = 0;
        visited = new boolean[11][11][4];
        
        for (char c : dirs.toCharArray()) {
            if (c == 'U') dir = 0;
            if (c == 'R') dir = 1;
            if (c == 'D') dir = 2;
            if (c == 'L') dir = 3;
            
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            if (ny < 0 || ny > 10 || nx < 0 || nx > 10) continue;
            
            if (!visited[ny][nx][dir]) {
                visited[ny][nx][dir] = true;
                visited[y][x][(dir + 2) % 4] = true;
                distance++;
            }
            
            y = ny;
            x = nx;
        }
        
        return distance;
    }
}