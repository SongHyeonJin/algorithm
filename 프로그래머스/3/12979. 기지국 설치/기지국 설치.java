import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int range = 0;
        
        for(int station : stations) {
            int l = station - w;
            int r = station + w;
            
            if (range < l) {
                int empty = l - range - 1;
                cnt += cntStation(empty, w);
                range = r;
            } else {
                range = Math.max(r, range);
            }
        }
        
        if (range < n) {
            int empty = n - range;
            cnt += cntStation(empty, w);
        }

        return cnt;
    }
    
    int cntStation(int empty, int w) {
        int mid = empty / (2 * w + 1);
        return (empty % (2 * w + 1) == 0) ? mid : mid + 1;
    }
}