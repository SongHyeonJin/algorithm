import java.util.*;

class Solution {
    static int member, earn;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        int[] distance = new int[emoticons.length];
        
        comb(distance, 0, users, emoticons);
        
        answer[0] = member;
        answer[1] = earn;
        return answer;
    }
    static void comb(int[] distance, int start, int[][] users, int[] emoticons) {
        if(start==distance.length) {
            calculate(distance, users, emoticons);
            return;
        }
        
        for(int i=10; i<=40; i+=10) {
            distance[start] = i;
            comb(distance, start+1, users, emoticons);
        }
    }
    static void calculate(int[] distance, int[][] users, int[] emoticons) {
        int cnt=0, money=0;
        
        for(int[] user : users) {
            int want = user[0];
            int price = user[1];
            int sum = 0;
            
            for(int i=0; i<distance.length; i++) {
                if(distance[i]>=want) {
                    sum += (emoticons[i]/100)*(100-distance[i]);
                }
            }
            if(sum>=price) cnt++;
            else money += sum;
        }
        if(cnt>member) {
            member = cnt;
            earn = money;
            return;
        }
        else if(cnt==member) {
            if(money>earn) {
                earn = money;
            }
        }
    }
}