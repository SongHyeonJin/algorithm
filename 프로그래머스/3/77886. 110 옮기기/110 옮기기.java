class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int idx = 0; idx < s.length; idx++) {
            String cur = s[idx];
            StringBuilder stack = new StringBuilder(cur.length());
            int count110 = 0;
            
            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);
                stack.append(c);

                int len = stack.length();
                if (len >= 3
                        && stack.charAt(len - 3) == '1'
                        && stack.charAt(len - 2) == '1'
                        && stack.charAt(len - 1) == '0') {
                    stack.delete(len - 3, len);
                    count110++;
                }
            }
            
            int lastZeroIdx = -1;
            for (int i = stack.length() - 1; i >= 0; i--) {
                if (stack.charAt(i) == '0') {
                    lastZeroIdx = i;
                    break;
                }
            }
            
            int insertPos = lastZeroIdx + 1;
            StringBuilder repeated110 = new StringBuilder(count110 * 3);
            for (int i = 0; i < count110; i++) {
                repeated110.append("110");
            }

            stack.insert(insertPos, repeated110);
            answer[idx] = stack.toString();
        }

        return answer;
    }
}