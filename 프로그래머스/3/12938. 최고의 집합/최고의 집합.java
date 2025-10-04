class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int init = s / n;
        int mod = s % n;
        
        for(int i=0; i<n; i++) {
            answer[i] = init;
        }
        
        int idx = n - 1;
        for(int i=0; i<mod; i++) {
            answer[idx]++;
            idx--;
        }
        
        return n > s ? new int[]{-1} : answer;
    }
}