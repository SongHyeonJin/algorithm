class Solution {
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};
    static boolean[][] visited;
    public int solution(int[][] board) {
        int answer = 0;
        int length = board.length;
        visited = new boolean[length][length];
        
        for(int i=0; i<length; i++)
            for(int j=0; j<length; j++)
                for(int k=0; k<8; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(board[i][j]==1) visited[i][j] = true;
                    if(nx>=0 && ny>=0 && nx<length && ny<length && board[nx][ny]==1) visited[i][j] = true;
                }
        for(int i=0; i<length; i++)
            for(int j=0; j<length; j++)
                if(!visited[i][j])
                    answer++;
        return answer;
    }
    
}