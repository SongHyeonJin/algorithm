class Solution {
    static char[] direction = {'d', 'l', 'r', 'u'};
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, -1, 1, 0};
    static StringBuilder sb = new StringBuilder();
    static String answer = null;
    static int row, col;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        row = n;
        col = m;
        
        int length = distance(x, y, r, c);
        if((k-length)%2==1 || k<length) return "impossible";
        
        dfs(x, y, r, c, 0, k);
        
        return answer==null ? "impossible" : answer;
    }
    static void dfs(int y1, int x1, int y2, int x2, int depth, int k) {
        if(answer!=null) return;
        if(depth+distance(y1, x1, y2, x2)>k) return;
        if(k==depth) {
            answer = sb.toString();
            return;
        }
        
        for(int i=0; i<4; i++) {
            int ny = y1 + dy[i];
            int nx = x1 + dx[i];
            
            if(0>=ny || ny>row || 0>=nx || nx>col) continue;
            
            sb.append(direction[i]);
            dfs(ny, nx, y2, x2, depth+1, k);
            sb.delete(depth, depth+1);
        }
    }
    static int distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y2-y1)+Math.abs(x2-x1);
    }
}