class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;

        
        String targetMelody = normalizeNotes(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int startTime = toMinutes(parts[0]);
            int endTime = toMinutes(parts[1]);
            String title = parts[2];
            String sheet = normalizeNotes(parts[3]);

            int playTime = endTime - startTime;
            if (playTime <= 0) {
                continue;
            }
            
            String playedMelody = buildPlayedMelody(sheet, playTime);

            
            if (playedMelody.contains(targetMelody)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }
    
    private int toMinutes(String hhmm) {
        String[] hm = hhmm.split(":");
        int hour = Integer.parseInt(hm[0]);
        int minute = Integer.parseInt(hm[1]);
        return hour * 60 + minute;
    }
    
    private String normalizeNotes(String notes) {
        return notes
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
    
    private String buildPlayedMelody(String sheet, int playTime) {
        int len = sheet.length();
        if (len == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder(playTime);
        int fullRepeats = playTime / len;
        int remainder = playTime % len;

        for (int i = 0; i < fullRepeats; i++) {
            sb.append(sheet);
        }
        sb.append(sheet, 0, remainder);

        return sb.toString();
    }
}