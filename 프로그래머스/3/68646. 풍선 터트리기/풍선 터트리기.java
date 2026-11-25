class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n <= 2) {
            return n;
        }
        
        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;
        int currentLeftMin = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = currentLeftMin;
            if (a[i] < currentLeftMin) {
                currentLeftMin = a[i];
            }
        }
        
        int[] rightMin = new int[n];
        rightMin[n - 1] = Integer.MAX_VALUE;
        int currentRightMin = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = currentRightMin;
            if (a[i] < currentRightMin) {
                currentRightMin = a[i];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < leftMin[i] || a[i] < rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}