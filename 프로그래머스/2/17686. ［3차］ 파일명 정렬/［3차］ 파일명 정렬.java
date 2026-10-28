import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] files1 = separationOfFile(o1);
            String[] files2 = separationOfFile(o2);

            int headComparison = files1[0].compareTo(files2[0]);

            if (headComparison == 0) {
                int num1 = Integer.parseInt(validateNum(files1[1]));
                int num2 = Integer.parseInt(validateNum(files2[1]));

                return Integer.compare(num1, num2);
            }

            return headComparison;
        });
        
        return files;
    }
    
    private String[] separationOfFile(String file) {
        file = file.toLowerCase();
        
        String head = file.split("[0-9]", 2)[0];
        String num = file.substring(head.length());
        return new String[]{head, num};
    }
    
    private String validateNum(String num) {
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (Character.isDigit(c) && sb.length() < 5) {
                sb.append(c);
            } else break;
        }
        
        return sb.toString();
    }
}