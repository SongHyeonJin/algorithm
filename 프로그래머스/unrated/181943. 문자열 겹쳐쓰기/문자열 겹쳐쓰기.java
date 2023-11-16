class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int mLen = my_string.length();
        int oLen = overwrite_string.length();
        String str1 = my_string.substring(0, s);
        String str2 = my_string.substring((s+oLen), mLen);
        answer = str1 + overwrite_string + str2;
        return answer;
    }
}