import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] files1 = separationOfFile(o1);
                String[] files2 = separationOfFile(o2);
                
                int answer = files1[0].compareTo(files2[0]);
                
                if (answer == 0) {
                    int num1 = Integer.parseInt(validateNum(files1[1]));
                    int num2 = Integer.parseInt(validateNum(files2[1]));
                    return num1 - num2;
                }
                return answer;
            }
        });
        
        return files;
    }
    
    String[] separationOfFile(String file) {
        file = file.toUpperCase();
        
        String head = file.split("[0-9]")[0];
        String num = file.substring(head.length());
        String[] separateFile = {head, num};
        return separateFile;
    }
    
    String validateNum(String num) {
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()) {
            if (Character.isDigit(c) && sb.length() <= 5) {
                sb.append(c);
            } else return sb.toString();
        }
        return sb.toString();
    }
}