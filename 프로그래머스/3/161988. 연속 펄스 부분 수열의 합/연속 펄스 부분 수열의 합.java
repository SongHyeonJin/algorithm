class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        long[] pulse1 = new long[n];
        long[] pulse2 = new long[n];
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                pulse1[i] = sequence[i];
                pulse2[i] = -sequence[i];
            } else {
                pulse1[i] = -sequence[i];
                pulse2[i] = sequence[i];
            }
        }
        
        long max1 = kadane(pulse1);
        long max2 = kadane(pulse2);
        
        return Math.max(max1, max2);
    }
    
    private long kadane(long[] arr) {
        long currentMax = arr[0];
        long globalMax = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }
}