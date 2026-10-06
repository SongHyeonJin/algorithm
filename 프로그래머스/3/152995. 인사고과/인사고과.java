import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoAtt = scores[0][0];
        int wanhoPeer = scores[0][1];
        int wanhoSum = wanhoAtt + wanhoPeer;
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        
        int maxPeer = 0;
        int rank = 1;
        
        for (int[] score : scores) {
            int att = score[0];
            int peer = score[1];
            
            if (peer < maxPeer) {
                if (att == wanhoAtt && peer == wanhoPeer) {
                    return -1;
                }
                continue;
            }
            
            maxPeer = Math.max(maxPeer, peer);
            
            if (att + peer > wanhoSum) {
                rank++;
            }
        }
        
        return rank;
    }
}