import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deploymentCounts = new ArrayList<>();
        int maxDays = 0;
        int currentGroupCount = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int requireDays = (remainingWork + speeds[i] - 1) / speeds[i];
            
            if (requireDays > maxDays) {
                if (currentGroupCount > 0) {
                    deploymentCounts.add(currentGroupCount);
                }
                maxDays = requireDays;
                currentGroupCount = 1;
            } else {
                currentGroupCount++;
            }
        }
        
        deploymentCounts.add(currentGroupCount);
        
        return deploymentCounts.stream().mapToInt(Integer::intValue).toArray();
    }
}