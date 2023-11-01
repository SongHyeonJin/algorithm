class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] strs = my_string.split(" ");
        
        answer += Integer.parseInt(strs[0]);
        
        for(int i=1; i<strs.length-1; i++){
            if(strs[i].equals("+")) answer += Integer.parseInt(strs[i+1]);
            else if(strs[i].equals("-")) answer -= Integer.parseInt(strs[i+1]);
        }
        return answer;
    }
}