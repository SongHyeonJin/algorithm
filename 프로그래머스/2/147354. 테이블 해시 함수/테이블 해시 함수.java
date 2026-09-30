import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] != o2[col - 1]) {
                return Integer.compare(o1[col - 1], o2[col - 1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });
        
        int answer = 0;
        
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int S_i = 0;
            
            for (int val : data[i]) {
                S_i += (val % (i + 1));
            }
            
            if (i == row_begin - 1) {
                answer = S_i;
            } else {
                answer ^= S_i;
            }
        }
        
        return answer;
    }
}