import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int len = 1;
        
        while(len<n)
            len *= 2;
        
        int[] answer = new int[len];
        Arrays.fill(answer, 0);
        System.arraycopy(arr, 0, answer, 0, n);
        return answer;
    }
}