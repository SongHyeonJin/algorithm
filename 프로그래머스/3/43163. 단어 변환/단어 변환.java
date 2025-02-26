class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    static void dfs(String cur, String target, String[] words, int cnt) {
        if(cur.equals(target)) {
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;
            int dif = 0;
            for(int j=0; j<cur.length(); j++) {
                if(cur.charAt(j)!=words[i].charAt(j)) {
                    dif++;
                }
            }
            if(dif==1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
            
        }
    }
}