class Solution {
    final int mod = 10007;
    public int solution(int n, int[] tops) {
        int[] a = new int[n];
        int[] b = new int[n];
        
        a[0] = 1;
        b[0] = (tops[0] == 1 ? 3 : 2);
        
        for(int i=1; i<n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % mod;
            b[i] = (tops[i] == 1 
                    ? (a[i -1] * 2 + b[i - 1] * 3) % mod
                    : (a[i - 1] + b[i - 1] * 2) % mod);
        }
        
        return (a[n - 1] + b[n - 1]) % mod;
    }
}