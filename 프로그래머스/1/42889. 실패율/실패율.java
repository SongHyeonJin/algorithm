import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        List<Stage> stageList = new ArrayList<>();
        
        int totalPlayers = stages.length;
        
        int[] currentPlayers = new int[N + 2];
        for (int stage : stages) {
            currentPlayers[stage]++;
        }
        
        for (int i = 1; i <= N; i++) {
            double failureRate = 0.0;
            
            if (totalPlayers > 0) {
                failureRate = (double) currentPlayers[i] / totalPlayers;
            }
            
            stageList.add(new Stage(i, failureRate));
            
            totalPlayers -= currentPlayers[i];
        }
        
        stageList.sort((a, b) -> {
            if (Double.compare(b.rate, a.rate) == 0) {
                return Integer.compare(a.stageNumber, b.stageNumber);
            }
            return Double.compare(b.rate, a.rate);
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNumber;
        }
        
        return answer;
    }
    
    private static class Stage {
        int stageNumber;
        double rate;
        
        public Stage(int stageNumber, double rate) {
            this.stageNumber = stageNumber;
            this.rate = rate;
        }
    }
}