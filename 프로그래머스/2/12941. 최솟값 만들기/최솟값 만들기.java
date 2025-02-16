import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;

        int[] C = new int[len];
        Arrays.sort(A);
        Arrays.sort(B);
        int idx=0;
        for(int i=len-1; i>=0; i--) {
            C[idx++] = B[i]; 
        }
        
        for(int i=0; i<len; i++) {
            answer += A[i]*C[i];
        }

        return answer;
    }
}