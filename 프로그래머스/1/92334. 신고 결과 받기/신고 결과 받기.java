import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedBy = new HashMap<>();
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String id : id_list) {
            reportedBy.put(id, new HashSet<>());
            countMap.put(id, 0);
        }

        for (String s : report) {
            String[] split = s.split(" ");
            reportedBy.get(split[1]).add(split[0]);
        }

        for (String id : id_list) {
            Set<String> reporters = reportedBy.get(id);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    countMap.put(reporter, countMap.get(reporter) + 1);
                }
            }
        }

        return countMap.values().stream().mapToInt(Integer::intValue).toArray();
    }
}