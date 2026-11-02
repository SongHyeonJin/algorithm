class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cell = board[i].charAt(j);
                
                if (cell == 'O') {
                    oCount++;
                } else if (cell == 'X') {
                    xCount++;
                }
            }
        }
        
        if (oCount < xCount || oCount > xCount + 1) {
            return 0;
        }

        boolean isOWin = hasPlayerWon(board, 'O');
        boolean isXWin = hasPlayerWon(board, 'X');
        
        if (isOWin && isXWin) {
            return 0;
        }
        
        if (isOWin && oCount != xCount + 1) {
            return 0;
        }
        
        if (isXWin && oCount != xCount) {
            return 0;
        }

        return 1;
    }
    
    private boolean hasPlayerWon(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
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