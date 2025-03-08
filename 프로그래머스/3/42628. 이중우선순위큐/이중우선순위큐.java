import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(int i=0; i<operations.length; i++) {
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            if(str[0].equals("I")) {
                maxQ.offer(num);
                minQ.offer(num);
            } else if(str[0].equals("D") && num==1 && !maxQ.isEmpty()) {
                minQ.remove(maxQ.poll());
            } else if(str[0].equals("D") && num==-1 && !minQ.isEmpty()) {
                maxQ.remove(minQ.poll());
            }
        }
        answer[0] = maxQ.isEmpty() ? 0 : maxQ.poll();
        answer[1] = minQ.isEmpty() ? 0 : minQ.poll();
        return answer;
    }
}