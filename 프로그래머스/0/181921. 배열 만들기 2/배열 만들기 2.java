import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for(int i=l; i<=r; i++){
            String num = String.valueOf(i);
            String[] nums = num.split("");
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j].equals("0") || nums[j].equals("5")) count++;
            }
            if(count == nums.length) answer.add(i);
        }
        if(answer.size() == 0) answer.add(-1);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}