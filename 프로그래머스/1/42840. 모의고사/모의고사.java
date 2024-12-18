import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] supo1 = {1,2,3,4,5};  // 5개 반복
        int[] supo2 = {2,1,2,3,2,4,2,5}; // 8개 반복
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5}; // 10개 반복
        int[] score = {0,0,0};
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == supo1[i%5]) score[0]++;
            if(answers[i] == supo2[i%8]) score[1]++;
            if(answers[i] == supo3[i%10]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        for(int i=0; i<score.length; i++)
            if(max==score[i]) answer.add(i+1);
    return answer.stream().mapToInt(m -> m).toArray();
    }
}