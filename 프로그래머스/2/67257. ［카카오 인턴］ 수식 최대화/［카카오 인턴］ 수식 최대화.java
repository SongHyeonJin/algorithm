import java.util.*;

class Solution {
    
    private static final String[][] PRIORITIES = {
        {"+", "-", "*"},
        {"+", "*", "-"},
        {"-", "+", "*"},
        {"-", "*", "+"},
        {"*", "+", "-"},
        {"*", "-", "+"}
    };

    public long solution(String expression) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        
        long maxResult = 0;
        
        for (String[] priority : PRIORITIES) {
            List<String> copyList = new ArrayList<>(tokens);
            
            for (String op : priority) {
                for (int i = 0; i < copyList.size(); i++) {
                    if (copyList.get(i).equals(op)) {
                        long left = Long.parseLong(copyList.get(i - 1));
                        long right = Long.parseLong(copyList.get(i + 1));
                        long res = calculate(left, right, op);
                        
                        copyList.remove(i - 1);
                        copyList.remove(i - 1);
                        copyList.remove(i - 1);
                        copyList.add(i - 1, String.valueOf(res));
                        
                        i--;
                    }
                }
            }
            
            long finalVal = Math.abs(Long.parseLong(copyList.get(0)));
            maxResult = Math.max(maxResult, finalVal);
        }
        
        return maxResult;
    }
    
    private long calculate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return 0;
        }
    }
}