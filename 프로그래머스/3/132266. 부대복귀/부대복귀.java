import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(destination);
        dist[destination] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}