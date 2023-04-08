class Solution {
    public long solution(long n) {
        long answer = 0;
        
        for(long i=0; i*i<=n; i++){
            if(i*i==n){
                answer = (i+1)*(i+1);
            }
        }
        return answer == 0 ? -1 : answer;
        // long answer = 0;
        // double sqrt = Math.sqrt(n);
        // if(sqrt%1!=0){
        //     answer = -1;
        // } else {
        //     answer = (long)(sqrt+1)*(long)(sqrt+1);
        // }
        // return answer;
    }
}