class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        // 3번의 기회 0~10점 
        String[] dart = dartResult.split("");
        int[] scores = new int[3];
        int idx = -1;
        
        for(int i=0; i<dartResult.length(); i++){
            // 숫자 확인
            if(dart[i].matches("[0-9]")){
                idx++;
                scores[idx] = Integer.parseInt(dart[i]);
                if(dart[i+1].matches("[0-9]")){
                    scores[idx] *= 10;
                    i++;
                }
            }
            
            // 보너스 or 옵션일 때 
            switch(dart[i]){
                case "S" :
                    scores[idx] = scores[idx];
                    break;
                case "D" :
                    scores[idx] = (int)Math.pow(scores[idx], 2);
                    break;
                case "T" :
                    scores[idx] = (int)Math.pow(scores[idx], 3);
                    break;
                case "*" :
                    scores[idx] *= 2;
                    if(idx - 1>=0) scores[idx-1] *= 2;
                    break;
                case "#" :
                    scores[idx] *= -1;
            }
        } 
        
        // 점수 계산
        for(int score : scores)
            answer += score;
        
        return answer;
    }
}