class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int same = 0;
        int zero = 0;
        
        // 로또 번호를 맞추면 갯수 올라감
        for(int i=0; i<win_nums.length; i++){
            for(int j=0; j<lottos.length; j++){
                if(win_nums[i]==lottos[j]){
                    same++;
                }
            }
        }
        // 0개수 확인
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                zero++;
            }
        }
        
        switch(same){
            case 0:
                // answer[0]은 
                answer[0]=6-zero+1; answer[1]=6;
                if(answer[0]==7)
                    answer[0]--;
                break;
            case 1:
                answer[0]=5-zero+1; answer[1]=6;
                break;
            case 2:
                answer[0]=4-zero+1; answer[1]=5;
                break;
            case 3:
                answer[0]=3-zero+1; answer[1]=4;
                break;
            case 4:
                answer[0]=2-zero+1; answer[1]=3;
                break;
            case 5:
                answer[0]=1-zero+1; answer[1]=2;
                break;
            case 6:
                answer[0]=1; answer[1]=1;
                break;
        }
        return answer;
    }
}