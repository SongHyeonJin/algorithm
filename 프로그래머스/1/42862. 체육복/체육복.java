class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 1. 학생 배열 생성
        int[] students = new int[n+2];
        // reserve / lost 정보 반영
        for(int l : lost)
            students[l]--;
        for(int r : reserve)
            students[r]++;
        
        // 여분 기준 앞뒤 확인해 체육복 빌려줌
        for(int i=1; i<=n; i++){
            if(students[i] == 1){
                if(students[i-1] == -1){
                    students[i]--;
                    students[i-1]++;
                }else if(students[i+1] == -1){
                    students[i]--;
                    students[i+1]++;
                }
            }
        }
        
        // 체육복 갖고 있는 학생수 계산
        for(int i=1; i<=n; i++){
            if(students[i] >= 0) answer++;
        }
        
        return answer;
    }
}