class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        for(int i=0; i<str.length; i++) {
            if(str[i].equals(" ")) {
                answer += " ";
                continue;
            }
            for(int j=0; j<str[i].length(); j++) {
                if(str[i].charAt(j) >= 'a' && str[i].charAt(j)<='z' && j==0) {
                    answer += (char)(str[i].charAt(j)-32);
                } else if(str[i].charAt(j) >= 'A' && str[i].charAt(j)<='Z' && j!=0) {
                    answer += (char)(str[i].charAt(j)+32);
                } else {
                    answer += str[i].charAt(j);
                }
            }
            if(i<str.length-1) answer+= " ";
        }
        if(s.charAt(s.length()-1)==' ') answer += " ";
        return answer;
    }
}