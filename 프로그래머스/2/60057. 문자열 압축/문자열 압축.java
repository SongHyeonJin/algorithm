class Solution {
    public int solution(String s) {
        int minLength = s.length();
        
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int compressedLength = getCompressedLength(s, unit);
            minLength = Math.min(minLength, compressedLength);
        }
        
        return minLength;
    }
    
    private int getCompressedLength(String s, int unit) {
        StringBuilder sb = new StringBuilder();
        
        String prev = s.substring(0, unit);
        int count = 1;
        
        for (int i = unit; i < s.length(); i += unit) {
            int endIndex = Math.min(i + unit, s.length());
            String current = s.substring(i, endIndex);
            
            if (prev.equals(current)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(prev);
                
                prev = current;
                count = 1;
            }
        }
        
        if (count > 1) {
            sb.append(count);
        }
        sb.append(prev);
        
        return sb.length();
    }
}