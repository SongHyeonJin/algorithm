import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int max = 0;
        for(int i=0; i<tangerine.length; i++) {
            max = Math.max(max, tangerine[i]);
        }
        
        int[] all = new int[max+1];
        for(int i=0; i<tangerine.length; i++) {
            all[tangerine[i]]++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i : all) {
            if(i!=0) list.add(i);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int sum=0;
        for(int i=0; i<list.size(); i++) {
            if(sum>=k) break;
            sum += list.get(i);
            answer++;
        }
        return answer;
    }
}