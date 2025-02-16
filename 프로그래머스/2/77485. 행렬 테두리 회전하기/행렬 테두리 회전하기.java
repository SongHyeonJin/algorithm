class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        
        int value = 1;
        for(int y=0; y<rows; y++) {
            for(int x=0; x<columns; x++) {
                board[y][x] = value++;
            }
        }
        for(int i=0; i<queries.length; i++) {
            int y1 = queries[i][0]-1;
            int x1 = queries[i][1]-1;
            int y2 = queries[i][2]-1;
            int x2 = queries[i][3]-1;
            
            int min = Integer.MAX_VALUE;
            int startVal = board[y1][x1];
            min = Math.min(min, startVal);
            for(int y=y1; y<y2; y++) {
                board[y][x1] = board[y+1][x1];
                min = Math.min(min, board[y][x1]);
            }
            for(int x=x1; x<x2; x++) {
                board[y2][x] = board[y2][x+1];
                min = Math.min(min, board[y2][x]);
            }
            for(int ty=y2; ty>y1; ty--) {
                board[ty][x2] = board[ty-1][x2];
                min = Math.min(min, board[ty][x2]);
            }
            for(int tx=x2; tx>x1+1; tx--) {
                board[y1][tx] = board[y1][tx-1];
                min = Math.min(min, board[y1][tx]);
            }
            board[y1][x1+1] = startVal;
            
            answer[i] = min;
        }
        return answer;
    }
}