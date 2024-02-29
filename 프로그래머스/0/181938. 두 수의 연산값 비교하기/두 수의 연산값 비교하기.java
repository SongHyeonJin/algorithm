class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str = String.valueOf(a) + String.valueOf(b);
        int num = Integer.parseInt(str);
        if(num >= 2*a*b)
            answer = num;
        else
            answer = 2*a*b;
        return answer;
    }
}