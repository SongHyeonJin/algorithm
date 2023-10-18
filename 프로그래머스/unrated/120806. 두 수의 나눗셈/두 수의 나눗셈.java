class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        float f = (float)num1/num2;
        f = f * 1000;
        answer = (int)f;
        return answer;
    }
}