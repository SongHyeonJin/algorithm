class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String s = String.valueOf(num);
        String[] strs = s.split("");
        
        for(int i=0; i<strs.length; i++){
            if(strs[i].equals(String.valueOf(k))) return i + 1;
        }
        return -1;
    }
}