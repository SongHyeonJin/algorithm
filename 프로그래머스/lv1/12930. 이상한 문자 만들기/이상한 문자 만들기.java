class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int a = 0;
        for(int i=0; i<str.length; i++){
            if(str[i].equals(" ")){
                a = 0;
            }else if(a%2==0){
                str[i] = str[i].toUpperCase();
                a++;
            }else{
                str[i] = str[i].toLowerCase();
                a++;
            }
            answer+=str[i];
        }
        return answer;
    }
}