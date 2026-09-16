class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";
        
        int splitIndex = getBalancedSplitIndex(p);
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);
        
        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            sb.append(getReverseString(u));
            
            return sb.toString();
        }
    }
    
    private int getBalancedSplitIndex(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            
            if (count == 0) return i + 1;
        }
        return s.length();
    }
    
    private boolean isCorrect(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
    
    private String getReverseString(String u) {
        StringBuilder sb = new StringBuilder();
        String sliced = u.substring(1, u.length() - 1);
        
        for (int i = 0; i < sliced.length(); i++) {
            if (sliced.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}