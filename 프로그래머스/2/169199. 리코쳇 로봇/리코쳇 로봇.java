import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    static class Node {
        int r, c, count;

        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        
        int startR = 0, startC = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'R') {
                    startR = i;
                    startC = j;
                    break;
                }
            }
        }
        
        return bfs(startR, startC, rows, cols, board);
    }
    
    private int bfs(int startR, int startC, int rows, int cols, String[] board) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.add(new Node(startR, startC, 0));
        visited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (board[current.r].charAt(current.c) == 'G') {
                return current.count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextR = current.r;
                int nextC = current.c;
                
                while (isValid(nextR + dr[i], nextC + dc[i], rows, cols, board)) {
                    nextR += dr[i];
                    nextC += dc[i];
                }
                
                if (visited[nextR][nextC]) {
                    continue;
                }
                
                visited[nextR][nextC] = true;
                queue.add(new Node(nextR, nextC, current.count + 1));
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int r, int c, int rows, int cols, String[] board) {
        return r >= 0 && r < rows && c >= 0 && c < cols && board[r].charAt(c) != 'D';
    }
}