import java.util.*;

class Solution {
    
    public int[] solution(String[] info, String[] query) {
        // 1. INFO 기반으로 hashMap 만듬
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        
        for(String i : info){
            String[] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);
                for(String language : languages)
                    for(String job : jobs)
                        for(String exp : exps)
                            for(String food : foods){
                                String[] keyData = {language, job, exp, food};
                                String key = String.join(" ", keyData);
                                ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());
                                
                                arr.add(value);
                                hashMap.put(key, arr);
                            }
        }
        
        // 2. 각 hashMap의 value를 오름차순 정렬
        for(ArrayList<Integer> arr : hashMap.values())
            arr.sort(null);
        
        // 3. query 조건 맞는 지원자 가져옴
        int[] answer = new int[query.length];
        int i=0;
        for(String q : query){
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);
            
            if(hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                // 4. 이분탐색으로 lower-bound 찾는다
                int left = 0;
                int right = list.size();
                while(left < right){
                    int mid = (left+right)/2;
                    if(list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }
                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }
}