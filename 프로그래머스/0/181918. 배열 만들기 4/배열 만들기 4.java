import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            if(stk.isEmpty()){
                stk.add(arr[i]);
                i++;
            } else{
                int last = stk.get(stk.size()-1);
                if(!stk.isEmpty() && last<arr[i]){
                    stk.add(arr[i]);
                    i++;
                } else if(!stk.isEmpty() && last>=arr[i])
                    stk.remove(stk.size()-1);
            }
        }
        return stk.stream().mapToInt(x -> x).toArray();
    }
}