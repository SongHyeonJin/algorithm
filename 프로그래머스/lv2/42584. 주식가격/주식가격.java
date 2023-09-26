import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> s = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            answer[i] = answer.length-1-i;
            Integer[] arr = {i, prices[i]};
            while(!s.empty() && s.peek()[1]>prices[i]){
                Integer[] price = s.pop();
                answer[price[0]] = i - price[0];
            }
            s.push(arr);
        }
        return answer;
    }
}