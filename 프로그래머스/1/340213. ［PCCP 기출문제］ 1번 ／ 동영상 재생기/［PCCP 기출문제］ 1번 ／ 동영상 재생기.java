class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = timeToSec(video_len);
        int curSec = timeToSec(pos);
        int opStartSec = timeToSec(op_start);
        int opEndSec = timeToSec(op_end);
        
        curSec = checkOpening(curSec, opStartSec, opEndSec);
        
        for (String command : commands) {
            if (command.equals("prev")) {
                curSec = Math.max(0, curSec - 10);
            } else if (command.equals("next")) {
                curSec = Math.min(videoLenSec, curSec + 10);
            }
            
            curSec = checkOpening(curSec, opStartSec, opEndSec);
        }
        
        return secToTime(curSec);
    }
    
    private int timeToSec(String timeStr) {
        String[] parts = timeStr.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }
    
    private String secToTime(int totalSec) {
        int min = totalSec / 60;
        int sec = totalSec % 60;
        return String.format("%02d:%02d", min, sec);
    }
    
    private int checkOpening(int curSec, int opStartSec, int opEndSec) {
        if (curSec >= opStartSec && curSec <= opEndSec) {
            return opEndSec;
        }
        return curSec;
    }
}