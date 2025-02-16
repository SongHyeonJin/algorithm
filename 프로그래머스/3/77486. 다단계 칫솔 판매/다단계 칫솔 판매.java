import java.util.*;

class Solution {
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> money = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++){
            commission(seller[i], amount[i]*100);
        }
        
        for(int i=0; i<enroll.length; i++) {
            answer[i] = money.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
    static void commission(String name, int sales) {
        int nextSales = sales/10;
        money.put(name, money.getOrDefault(name, 0)+sales-nextSales);
        
        if(nextSales>0 && parent.containsKey(name))
            commission(parent.get(name), nextSales);
    }
}