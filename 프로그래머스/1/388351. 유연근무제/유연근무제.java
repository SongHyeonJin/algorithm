class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int limitTime = toMinute(schedules[i]) + 10;
            boolean isSuccess = true;
            
            for (int j = 0; j < 7; j++) {
                int currentDay = (startday - 1 + j) % 7;
                
                if (currentDay == 5 || currentDay == 6) {
                    continue;
                }
                
                int actualTime = toMinute(timelogs[i][j]);
                
                if (actualTime > limitTime) {
                    isSuccess = false;
                    break;
                }
            }
            
            if (isSuccess) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int toMinute(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return hour * 60 + minute;
    }
}