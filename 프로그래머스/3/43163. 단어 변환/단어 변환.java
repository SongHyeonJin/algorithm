class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    static void dfs(String now, String target, String[] words, int cnt){
        if(now.equals(target)){
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            int a = 0;
            for(int j=0; j<now.length(); j++){
               if(now.charAt(j) != words[i].charAt(j)) a++;
            }
            if(a==1){
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
    
}