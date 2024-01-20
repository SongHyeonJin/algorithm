import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failRate = new double[N];
        int player = stages.length;
        Map<Integer, Integer> fail = new HashMap<>();
        
        for(int i=1; i<=N; i++)
            fail.put(i, count(stages, i));
        
        int index = 0;
        for(Integer key : fail.keySet()){
            failRate[index++] = (double)fail.get(key) / player;
            
            if(player == fail.get(key)) player = 1;
            else player -= fail.get(key);
        }
        
        Double[] temp = new Double[N];
        for(int i=0; i<N; i++)
            temp[i] = failRate[i];
        
        Arrays.sort(temp, Collections.reverseOrder());
        
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(failRate[i] == temp[j]){
                    if(answer[j] != 0)
                        continue;
                    answer[j] = i+1;
                    break;
                }    
        return answer;
    }
    
    static int count(int[] arr, int n){
        int count = 0;
        for(int i : arr)
            if(i == n)
                count++;
        return count;
    }
}