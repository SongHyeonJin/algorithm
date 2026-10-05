import java.util.*;

class Solution {
    private static final int[][] COST_TABLE = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    static class MineralGroup {
        int dia, iron, stone, stoneCost;

        public MineralGroup(int dia, int iron, int stone, int stoneCost) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
            this.stoneCost = stoneCost;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        
        List<MineralGroup> groups = new ArrayList<>();
        
        for (int i = 0; i < maxMinerals; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            
            for (int j = i; j < i + 5 && j < maxMinerals; j++) {
                char c = minerals[j].charAt(0);
                if (c == 'd') dia++;
                else if (c == 'i') iron++;
                else stone++;
            }
            
            int stoneCost = dia * 25 + iron * 5 + stone;
            groups.add(new MineralGroup(dia, iron, stone, stoneCost));
        }
        
        Collections.sort(groups, (o1, o2) -> Integer.compare(o2.stoneCost, o1.stoneCost));
        
        int totalFatigue = 0;
        
        for (MineralGroup group : groups) {
            int pickType = -1;
            
            if (picks[0] > 0) {
                pickType = 0;
                picks[0]--;
            } else if (picks[1] > 0) {
                pickType = 1;
                picks[1]--;
            } else if (picks[2] > 0) {
                pickType = 2;
                picks[2]--;
            } else break;
            
            totalFatigue += group.dia * COST_TABLE[pickType][0];
            totalFatigue += group.iron * COST_TABLE[pickType][1];
            totalFatigue += group.stone * COST_TABLE[pickType][2];
        }
        
        return totalFatigue;
    }
}