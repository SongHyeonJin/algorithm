import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> pairs1 = generatePairs(str1);
        List<String> pairs2 = generatePairs(str2);
        
        if (pairs1.isEmpty() && pairs2.isEmpty()) return 65536;
        
        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for (String pair : pairs1) {
            if (pairs2.remove(pair)) {
                inter.add(pair);
            }
            union.add(pair);
        }
        union.addAll(pairs2);
        
        double jaccard = (double) inter.size() / union.size();
        return (int) (jaccard * 65536);
    }
    
    private List<String> generatePairs(String str) {
        List<String> pairs = new ArrayList<>();
        String lowerStr = str.toLowerCase();
        
        for (int i = 0 ; i < lowerStr.length() - 1; i++) {
            char c1 = lowerStr.charAt(i);
            char c2 = lowerStr.charAt(i + 1);
            
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                pairs.add("" + c1 + c2);
            }
        }
        
        return pairs;
    }
}