import java.util.*;

class Solution {
    private Map<String, Integer> courseMap;
    private int maxCount;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] menus = orders[i].toCharArray();
            Arrays.sort(menus);
            orders[i] = new String(menus);
        }
        
        for (int courseSize : course) {
            courseMap = new HashMap<>();
            maxCount = 0;

            for (String order : orders) {
                if (order.length() >= courseSize) {
                    findCombinations(0, 0, order, new StringBuilder(), courseSize);
                }
            }

            if (maxCount >= 2) {
                for (String key : courseMap.keySet()) {
                    if (courseMap.get(key) == maxCount) {
                        answerList.add(key);
                    }
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    private void findCombinations(int depth, int idx, String order, StringBuilder sb, int courseSize) {
        if (depth == courseSize) {
            String course = sb.toString();
            int count = courseMap.getOrDefault(course, 0) + 1;
            courseMap.put(course, count);
            maxCount = Math.max(maxCount, count);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            findCombinations(depth + 1, i + 1, order, sb, courseSize);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}