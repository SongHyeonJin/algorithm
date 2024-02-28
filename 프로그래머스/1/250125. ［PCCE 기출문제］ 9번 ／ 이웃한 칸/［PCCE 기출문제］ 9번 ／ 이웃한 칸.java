class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int length = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for(int i=0; i<4; i++){
            int newH = h + dh[i];
            int newW = w + dw[i];
            if(newH>=0 && newH<length && newW>=0 && newW<length)
                if(board[h][w].equals(board[newH][newW]))
                    answer++;
        }
        return answer;
    }
}