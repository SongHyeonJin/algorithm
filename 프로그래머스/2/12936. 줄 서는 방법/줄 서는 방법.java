import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        
        k--; 
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            
            int selectedIndex = (int) (k / factorial);
            answer[idx++] = numbers.get(selectedIndex);
            
            numbers.remove(selectedIndex);
            
            k %= factorial;
        }
        
        return answer;
    }
}