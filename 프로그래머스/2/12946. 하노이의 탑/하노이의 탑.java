import java.util.*;

class Solution {
    private List<int[]> moves;
    public int[][] solution(int n) {
        moves = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }
        
        hanoi(n - 1, from, aux, to);
        
        moves.add(new int[]{from, to});
        
        hanoi(n - 1, aux, to, from);
    }
}