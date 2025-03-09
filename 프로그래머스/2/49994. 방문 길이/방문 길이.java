class Solution {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][][] visited;
    public int solution(String dirs) {
        int y=5, x=5, dir=-1, answer=0;
        visited = new boolean[11][11][4];
        
        for(char c : dirs.toCharArray()) {
            if(c=='U') dir=0;
            if(c=='R') dir=1;
            if(c=='D') dir=2;
            if(c=='L') dir=3;
            
            int ny = y+dy[dir];
            int nx = x+dx[dir];
            if(ny<0 || nx<0 || ny>10 || nx>10) continue;
            if(!visited[ny][nx][dir]) {
                visited[ny][nx][dir] = true;
                visited[y][x][(dir+2)%4] = true;
                answer++;
            }
            y = ny;
            x = nx;
        }
        return answer;
    }
}