class Solution {
    boolean solution(String s) {
        int openCount = 0;;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                if (openCount == 0) return false;
                openCount--;
            }
        }

        return openCount == 0;
    }
}