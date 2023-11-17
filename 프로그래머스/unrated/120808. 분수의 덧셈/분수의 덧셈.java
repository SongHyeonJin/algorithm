class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int boonja = numer1*denom2 + numer2*denom1;
        int boonmo = denom1*denom2;
        
        for(int i=boonja-1; i>1; i--)
            if(boonja%i==0 && boonmo%i==0){
                boonja /= i;
                boonmo /= i;
            }
        int[] answer = {boonja, boonmo};
        return answer;
    }
}