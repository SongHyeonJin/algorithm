import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] groups = s.split("\\},\\{");
        
        Arrays.sort(groups, Comparator.comparingInt(String::length));
        
        Set<Integer> uniqueTuple = new LinkedHashSet<>();
        
        for (String group : groups) {
            String[] numbers = group.split(",");
            for (String number : numbers) {
                uniqueTuple.add(Integer.parseInt(number));
            }
        }
        
        return uniqueTuple.stream().mapToInt(Integer::intValue).toArray();
    }
}