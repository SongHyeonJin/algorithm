class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int sum = 0;
        int nonum = 0;
        for(int i=0; i<10; i++){
            sum += i;
        }
        for(int j=0; j<numbers.length; j++){
            nonum += numbers[j];
        }
        answer=sum-nonum;
        return answer;
    }
}