import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int len = sizes.length;
        
        int[] width = new int[len];
        int[] height = new int[len];
       
        for(int i=0; i<len; i++){
            width[i] = Math.max(sizes[i][0], sizes[i][1]);
            height[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        Arrays.sort(width);
        Arrays.sort(height);
       
        answer = width[len-1]*height[len-1];
        return answer;
    }
}