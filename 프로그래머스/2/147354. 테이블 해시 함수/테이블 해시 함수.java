import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (row1, row2) -> {
            if (row1[col - 1] == row2[col - 1]) {
                return Integer.compare(row2[0], row1[0]);
            }
            return Integer.compare(row1[col - 1], row2[col - 1]);
        });
        
        int answer = 0;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int rowNumber = i + 1;
            int rowSum = calculateRowSum(data[i], rowNumber);
            
            if (i == row_begin - 1) {
                answer = rowSum;
            } else  {
                answer ^= rowSum;
            }
        }
        
        return answer;
    }
    
    private int calculateRowSum(int[] row, int rowNumber) {
        int sum = 0;
        for (int val : row) {
            sum += (val % rowNumber);
        }
        
        return sum;
    }
}