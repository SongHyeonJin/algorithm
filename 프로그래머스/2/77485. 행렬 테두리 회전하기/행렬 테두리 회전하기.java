import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = initializeBoard(rows, columns);
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            
            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;
            
            answer[i] = rotateAndGetMin(board, y1, x1, y2, x2);
        }
        
        return answer;
    }

    private int[][] initializeBoard(int rows, int columns) {
        int[][] board = new int[rows][columns];
        int value = 1;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                board[y][x] = value++;
            }
        }
        return board;
    }
    
    private int rotateAndGetMin(int[][] board, int y1, int x1, int y2, int x2) {
        int minValue = Integer.MAX_VALUE;
        int startValue = board[y1][x1];
        minValue = Math.min(minValue, startValue);

        for (int y = y1; y < y2; y++) {
            board[y][x1] = board[y + 1][x1];
            minValue = Math.min(minValue, board[y][x1]);
        }

        for (int x = x1; x < x2; x++) {
            board[y2][x] = board[y2][x + 1];
            minValue = Math.min(minValue, board[y2][x]);
        }

        for (int y = y2; y > y1; y--) {
            board[y][x2] = board[y - 1][x2];
            minValue = Math.min(minValue, board[y][x2]);
        }

        for (int x = x2; x > x1 + 1; x--) {
            board[y1][x] = board[y1][x - 1];
            minValue = Math.min(minValue, board[y1][x]);
        }

        board[y1][x1 + 1] = startValue;

        return minValue;
    }
}