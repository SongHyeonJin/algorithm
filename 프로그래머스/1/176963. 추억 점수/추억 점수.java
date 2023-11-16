import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // hashmap 만들기
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++)
            map.put(name[i], yearning[i]);
        
        // 숫자 만들기
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
        return answer;
    }
}