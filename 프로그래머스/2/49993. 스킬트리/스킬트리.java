import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        for(int i=0; i<skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]","");
            boolean flag = true;
            for(int j=0; j<skill_trees[i].length(); j++) {
                if(skill.charAt(j)!=skill_trees[i].charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}