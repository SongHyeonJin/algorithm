import java.util.*;

class Solution {
    static String[] arr = new String[]{"A","E","I","O","U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs(0, "");
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        return answer;
    }
    static void dfs(int index, String str){
        if(index>=5) return;
        for(int i=0; i<arr.length; i++){
            list.add(str+arr[i]);
            dfs(index+1, str+arr[i]);
        }
    }
}