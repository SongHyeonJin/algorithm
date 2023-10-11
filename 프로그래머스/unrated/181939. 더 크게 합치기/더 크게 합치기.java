class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = Integer.toString(a) + Integer.toString(b);
        String str2 = Integer.toString(b) + Integer.toString(a);
        return Integer.parseInt(str1) >= Integer.parseInt(str2) ? Integer.parseInt(str1) : Integer.parseInt(str2);
    }
}