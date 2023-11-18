class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        int idx = 0;
        // 모든 글자 A로 시작
        for(int i=0; i<name.length(); i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            idx = i+1;
            while(idx < name.length() && name.charAt(idx) == 'A')
                idx++;
            move = Math.min(move, i*2+name.length()-idx);
            move = Math.min(move, (name.length()-idx)*2+i);
        }  
        
        return answer+move;
    }
}