class Solution {
    public int solution(String s) {
        int n = s.length();
        
        if (n == 1) return 1;
        
        int minLength = n;

        for (int unit = 1; unit <= n / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            
            String prev = s.substring(0, unit);
            int count = 1;
            
            for (int i = unit; i < n; i += unit) {
                int endIndex = Math.min(i + unit, n);
                String sub = s.substring(i, endIndex);
                
                if (prev.equals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    
                    prev = sub;
                    count = 1;
                }
            }
            
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);
            
            minLength = Math.min(minLength, compressed.length());
        }
        
        return minLength;
    }
}