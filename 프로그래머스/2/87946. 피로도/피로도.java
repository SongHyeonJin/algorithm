import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    static void dfs(int idx, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(idx+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, idx);
    }
}