import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int answer = 0;
        
        Map<String, Integer> friendsMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            friendsMap.put(friends[i], i);
        }
        
        int[] giftDegree = new int[n];
        int[][] giftGraph = new int[n][n];
        
        for(String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftDegree[friendsMap.get(giftName[0])]++;
            giftDegree[friendsMap.get(giftName[1])]--;
            giftGraph[friendsMap.get(giftName[0])][friendsMap.get(giftName[1])]++;
        }
        
        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if (i == j) continue;
                
                if (giftGraph[i][j] > giftGraph[j][i]
                    || giftGraph[i][j] == giftGraph[j][i]
                    && giftDegree[i] > giftDegree[j]) cnt++;
            }
            if (answer < cnt) answer = cnt;
        }
        
        return answer;
    }
}