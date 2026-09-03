class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    matchCount++;
                    break;
                }
            }
        }
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        int maxRank = rank[matchCount + zeroCount];
        int minRank = rank[matchCount];
        
        return new int[]{maxRank, minRank};
    }
}