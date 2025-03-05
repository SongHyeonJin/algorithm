import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String> list = new ArrayList<>();
        
        int idx=1;
        while(idx<s.length()) {
            if(s.charAt(idx)=='{') {
                String str = "";
                for(int i=idx+1; i<s.length(); i++) {
                    if(s.charAt(i)=='}') break;
                    str += s.charAt(i);
                }
                list.add(str);
            }
            idx++;
        }
        
        List<Integer> answer = new ArrayList<>();
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(int i=0; i<list.size(); i++) {
             String[] strs = list.get(i).split(",");
            for (String str : strs) {
                int num = Integer.parseInt(str);
                if(!answer.contains(num)) answer.add(num);
            }
        }
        return answer.stream().mapToInt(n -> n).toArray();
    }
}