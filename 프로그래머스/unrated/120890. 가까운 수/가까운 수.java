import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++){
            list.add(Math.abs(array[i]-n));
        }
        int min = list.get(0);
        int idx = 0;
        for(int i=1; i<list.size(); i++){
            if(list.get(i) < min){
                min = list.get(i);
                idx = i;
            }
        }
        answer = array[idx];
        return answer;
    }
}