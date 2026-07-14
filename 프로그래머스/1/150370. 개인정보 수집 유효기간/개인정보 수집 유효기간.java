import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }
        
        long todayTotalDays = convertToDays(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            long privacyDate = convertToDays(split[0]);
            int termMonths = termMap.get(split[1]);
            
            if (todayTotalDays >= privacyDate + (termMonths * 28L)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int convertToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}