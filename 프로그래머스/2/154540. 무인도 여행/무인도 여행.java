import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    public int[] solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> islandSums = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'X' || visited[i][j]) {
                    continue;
                }
                
                int sum = bfs(i, j, rows, cols, board, visited);
                islandSums.add(sum);
            }
        }
        
        if (islandSums.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(islandSums);
        
        int[] answer = new int[islandSums.size()];
        for (int i = 0; i < islandSums.size(); i++) {
            answer[i] = islandSums.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int startR, int startC, int rows, int cols, String[] board, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        int totalFood = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            totalFood += board[r].charAt(c) - '0';
            
            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols) {
                    if (board[nextR].charAt(nextC) != 'X' && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        
        return totalFood;
    }
}