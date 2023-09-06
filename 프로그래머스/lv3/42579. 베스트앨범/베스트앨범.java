import java.util.*;

class Solution {
    static class Music{
        String genre;
        int play;
        int index;
        public Music(String genre, int play, int index){
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genres_ordered = new ArrayList<>();
        while(map.size() != 0){
            int max = 0;
            String max_key = "";
            for(String key : map.keySet()){
                int count = map.get(key);
                if(count > max){
                    max = count;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key);
        }
        List<Music> result = new ArrayList<>();
        for(String genre : genres_ordered){
            List<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(new Music(genre, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size() != 1){
                result.add(list.get(1));
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).index;
        }
        return answer;
    }
}