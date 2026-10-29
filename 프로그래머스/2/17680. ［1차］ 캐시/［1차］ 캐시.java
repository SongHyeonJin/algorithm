import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int totalTime = 0;
        
        Map<String, Boolean> cache = new LinkedHashMap<String, Boolean>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };
        
        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            
            if (cache.containsKey(lowerCity)) {
                totalTime += 1;
            } else {
                totalTime += 5;
            }
            
            cache.put(lowerCity, true);
        }
        
        return totalTime;
    }
}