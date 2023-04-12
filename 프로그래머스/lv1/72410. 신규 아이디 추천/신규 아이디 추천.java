import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계
        new_id = new_id.toLowerCase();
        //2단계
        for(int i=0; i<new_id.length(); i++){
            char id = new_id.charAt(i);
            if((id >= 'a'&& id<='z') || (id >= '0' && id <= '9') || id == '-' || id == '_' || id == '.'){
                answer += id;
            }
        }
        // 3단계
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        // 4단계
        if(answer.length() > 0){
            if(answer.startsWith(".")) answer = answer.substring(1);
            if(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
        }
        // 5단계
        if(answer.equals("")) answer="a";
        // 6단계
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        if(answer.endsWith(".")) answer = answer.substring(0,14);
        // 7단계
        if(answer.length()<=2){
            char c = answer.charAt(answer.length()-1);
            while(answer.length()<3){
                answer+=c;
            }
        }
        return answer;
    }
}