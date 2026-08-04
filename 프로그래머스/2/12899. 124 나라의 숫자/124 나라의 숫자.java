class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"4", "1", "2"};
        
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;
            
            if (remainder == 0) {
                n--;
            }
            
            sb.insert(0, numbers[remainder]);
        }
        
        return sb.toString();
    }
}