import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int deployDay = days[0];
        int count = 0;
        
        for (int i = 0; i < days.length; i++) {
            if (days[i] <= deployDay) {
                count++;
            } else {
                answer.add(count);
                deployDay = days[i];
                count = 1;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}