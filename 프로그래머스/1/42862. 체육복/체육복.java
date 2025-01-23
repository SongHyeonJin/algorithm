class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n+2];
        
        for(int i=0; i<lost.length; i++)
            student[lost[i]]--;
        
        for(int i=0; i<reserve.length; i++)
            student[reserve[i]]++;
        
        
        for(int i=0; i<student.length; i++) {
            if(student[i]==-1) {
                if(student[i-1]==1) {
                    student[i]++;
                    student[i-1]--;
                } else if(student[i+1]==1) {
                    student[i]++;
                    student[i+1]--;
                }
            }
        }
        
        
        for(int i=1; i<student.length-1; i++)
            if(student[i]!=-1) answer++;
        return answer;
    }
}