class Solution {
    static int answer;
    public int solution(int n) {
        answer = 0;
        int sum=0;
        for(int i=1; i<=n; i++) {
            dfs(i, n, sum);
        }
        return answer;
    }
    static void dfs(int num, int n, int sum) {
        if(sum==n) {
            answer++;
            return;
        }
        if(sum>n) {
            sum=0;
            return;
        }
        dfs(num+1, n, sum+num);
    }
}