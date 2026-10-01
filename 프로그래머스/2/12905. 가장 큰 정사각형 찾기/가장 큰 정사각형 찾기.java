class Solution {
    public int solution(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int maxSide = 0;
        
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 1) {
                maxSide = 1;
                break;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 1) {
                maxSide = 1;
                break;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    int minVal = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1]));
                    
                    board[i][j] = minVal + 1;
                    
                    maxSide = Math.max(maxSide, board[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}