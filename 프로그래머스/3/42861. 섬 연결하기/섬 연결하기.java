import java.util.*;

class Solution {
    
    private int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int edgeCount = 0;
        
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            if (find(from) != find(to)) {
                union(from, to);
                totalCost += weight;
                edgeCount++;
                
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
    
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}