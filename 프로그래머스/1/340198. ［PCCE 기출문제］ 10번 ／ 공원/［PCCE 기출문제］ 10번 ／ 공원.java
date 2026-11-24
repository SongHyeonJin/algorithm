import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            for (int r = 0; r <= rows - size; r++) {
                for (int c = 0; c <= cols - size; c++) {
                    if (canPlace(park, r, c, size)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean canPlace(String[][] park, int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!"-1".equals(park[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}