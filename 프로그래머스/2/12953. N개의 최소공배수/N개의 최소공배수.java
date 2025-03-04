import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        while(!check(arr, answer)) {
            answer++;
        }
        
        return answer;
    }
    static boolean check(int[] arr, int num) {
        for(int i=0; i<arr.length; i++) {
            if(num%arr[i]!=0) return false;
        }
        return true;
    }
}