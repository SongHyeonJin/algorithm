import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int count = 1;

        while(true) {
            int layerMax = ((num-1 + w) / w) * w;
            int topBox = num+(layerMax-num)*2+1;
            
            if(n<=layerMax) {
                if(n<num) answer = count-1;
                else answer = count;
                break;
            } else {
                count++;
                num = topBox;
            }
        }
        return answer;
    }
}