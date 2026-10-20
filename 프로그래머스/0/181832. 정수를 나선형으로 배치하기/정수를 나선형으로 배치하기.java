class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int r = 0, c = 0;
        int dir = 0;
        
        for (int i = 1; i <= n * n; i++) {
            answer[r][c] = i;
            
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || answer[nextR][nextC] != 0) {
                dir = (dir + 1) % 4;
                nextR = r + dr[dir];
                nextC = c + dc[dir];
            }
            
            r = nextR;
            c = nextC;
        }
        
        return answer;
    }
}