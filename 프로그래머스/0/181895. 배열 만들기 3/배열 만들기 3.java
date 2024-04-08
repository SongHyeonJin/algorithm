import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(i>=intervals[0][0] && i<=intervals[0][1])
                answer.add(arr[i]);
            else
                continue;
        }
        
        for(int i=0; i<arr.length; i++){
            if(i>=intervals[1][0] && i<=intervals[1][1])
                answer.add(arr[i]);
            else
                continue;
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}