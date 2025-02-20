import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        ArrayList<String> carNumber = new ArrayList<>();

        for (String record : records) {
            String[] str = record.split(" ");
            int time = getRealTime(str[0]);
            String car = str[1];
            String type = str[2];

            if (type.equals("IN")) {
                map.put(car, time);
            } else if (type.equals("OUT")) {
                int startTime = map.get(car);
                map.remove(car);
                if(timeMap.containsKey(car)) {
                    int totalTime = timeMap.get(car);
                    timeMap.put(car, totalTime+time-startTime);
                } else {
                    timeMap.put(car, time-startTime);
                }
            }
        }
        
        for (String s : map.keySet()) {
            int startTime = map.get(s);
            int totalTime = 1439;
            if(timeMap.containsKey(s)) {
                timeMap.put(s, timeMap.get(s)+totalTime-startTime);
            } else {
                timeMap.put(s, totalTime-startTime);
            }
        }
        for (String s : timeMap.keySet()) {
            carNumber.add(s);
        }
        
        Collections.sort(carNumber);
        for(String s : carNumber){
            int price = pay(fees[0], fees[1], fees[2], fees[3], timeMap.get(s));
            answer.add(price);
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }

    static int pay(int mainTime, int mainFee, int plusTime, int plusFee, int time) {
        int useTime=0;
        if(time<=mainTime) return mainFee;
        else {
            if((time-mainTime)%plusTime==0 || plusTime==1) {
                useTime = (time-mainTime)/plusTime;
            } else {
                useTime = (time-mainTime)/plusTime+1;
            }
            return mainFee+useTime*plusFee;
        }
    }
    static int getRealTime(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
}