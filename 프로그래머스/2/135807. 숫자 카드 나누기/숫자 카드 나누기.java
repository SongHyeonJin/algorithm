import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int m = arrayB.length;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int x = arrayA[0];
        for(int i=1; i<n; i++) {
            x = gcd(arrayA[i], x);
        }
        
        int y = arrayB[0];
        for(int i=1; i<m; i++) {
            y = gcd(arrayB[i], y);
        }
        
        if (!isDivided(arrayB, x)) {
            answer = Math.max(answer, x);
        }
        
        if (!isDivided(arrayA, y)) {
            answer = Math.max(answer, y);
        }
        
        return answer;
    }
    
    int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
    
    boolean isDivided(int[] arr, int a) {
        boolean divided = false;
        
        if (a <= 1) return true;
        
        for(int i=0; i<arr.length; i++) {
            if (arr[i] % a == 0) divided = true;
        }
        
        return divided;
    }
}