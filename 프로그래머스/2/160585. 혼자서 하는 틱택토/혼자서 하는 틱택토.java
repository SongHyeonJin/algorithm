class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') oCount++;
                else if (board[i].charAt(j) == 'X') xCount++;
            }
        }
        
        if (oCount < xCount || oCount > xCount + 1) {
            return 0;
        }
        
        boolean isOWon = checkWin(board, 'O');
        boolean isXWon = checkWin(board, 'X');
        
        if (isOWon && isXWon) {
            return 0;
        }
        
        if (isOWon && oCount != xCount + 1) {
            return 0;
        }
        
        if (isXWon && oCount != xCount) {
            return 0;
        }
        
        return 1;
    }
    
    private boolean checkWin(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player && board[1].charAt(j) == player && board[2].charAt(j) == player) {
                return true;
            }
        }
        
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }
        
        return false;
    }
}