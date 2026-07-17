import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int count = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        recursive("", numbers, visited);
        
        for (int num : set) {
            if (isPrime(num)) count++;
        }
        
        return count;
    }
    
    private void recursive(String curr, String numbers, boolean[] visited) {
        if (!curr.equals("")) {
            set.add(Integer.parseInt(curr));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursive(curr + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i  <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}