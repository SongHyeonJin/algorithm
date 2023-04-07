import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;
        int num = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                cnt++;
            }
        }
        if(cnt==0){
                int[] arr2={-1};
                return arr2;
            }
        
        int[] arr2 = new int[cnt];
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                arr2[num] = arr[i];
                num++;
            }
        }
        Arrays.sort(arr2);
        return arr2;
    }
}