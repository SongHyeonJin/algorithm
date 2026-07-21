import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            int count = bfs(v1, n, graph);
            
            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return minDiff;
    }
    
    private int bfs(int start, int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}