import java.util.*;

class Solution {
    private final String[][] PRIORITIES = {
        {"+", "-", "*"},
        {"+", "*", "-"},
        {"-", "+", "*"},
        {"-", "*", "+"},
        {"*", "+", "-"},
        {"*", "-", "+"}
    };
    
    public long solution(String expression) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        long maxResult = 0;
        for (String[] priority : PRIORITIES) {
            List<String> workingList = new LinkedList<>(tokens);
            
            for (String operation : priority) {
                for (int i = 0; i < workingList.size(); i++) {
                    if (workingList.get(i).equals(operation)) {
                        long leftOperand = Long.parseLong(workingList.get(i - 1));
                        long rightOperand = Long.parseLong(workingList.get(i + 1));
                        long calculatedValue = calculate(leftOperand, rightOperand, operation);
                        
                        workingList.remove(i - 1);
                        workingList.remove(i - 1);
                        workingList.remove(i - 1);
                        workingList.add(i - 1, String.valueOf(calculatedValue));
                        
                        i--;
                    }
                }
            }
            
            long finalVal = Math.abs(Long.parseLong(workingList.get(0)));
            maxResult = Math.max(maxResult, finalVal);
        }
        
        return maxResult;
    }
    
    private long calculate(long a, long b, String operation) {
        switch (operation) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            default : return 0;
        }
    }
}