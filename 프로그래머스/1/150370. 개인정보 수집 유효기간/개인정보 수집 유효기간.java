import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> period = new HashMap<>();
        int todayY = Integer.parseInt(today.substring(0, 4));
        int todayM = Integer.parseInt(today.substring(5, 7));
        int todayD = Integer.parseInt(today.substring(8, 10));
        
        for(int i=0; i<terms.length; i++) {
            String[] s = terms[i].split(" ");
            period.put(s[0], Integer.parseInt(s[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int year = Integer.parseInt(s[0].substring(0, 4));
            int month = Integer.parseInt(s[0].substring(5, 7));
            int day = Integer.parseInt(s[0].substring(8, 10));
            String type = s[1];
            
            int plusMonth = period.get(type);
            
            month += plusMonth;
            while(month>12) {
                year++;
                month-=12;
            }
            day--;
            if(day==0) {
                month--;
                day+=28;
            }
            
            if(month==0) {
                year--;
                month+=12;
            }
            
            if(todayY>year) {
                answer.add(i+1);
            } else if(todayY==year && todayM>month) {
                answer.add(i+1);
            } else if(todayY==year && todayM==month && todayD>day) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(a -> a).toArray();
    }
}