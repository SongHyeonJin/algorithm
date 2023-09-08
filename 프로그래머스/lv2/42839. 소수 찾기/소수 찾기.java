import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static char[] arr;
    public int solution(String numbers) {
        int answer = 0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }
        dfs("",0);
        answer = set.size();
        return answer;
    }
    
    static boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        for(int i=2; i*i<= num; i++)
            if(num%i==0) return false;
        return true;
    }
    
    public void dfs(String str, int index){
        int num;
        if(str != ""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        if(index == arr.length) return;
        for(int i=0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(str+arr[i], index+1);
            visited[i] = false;
        }
    }
}