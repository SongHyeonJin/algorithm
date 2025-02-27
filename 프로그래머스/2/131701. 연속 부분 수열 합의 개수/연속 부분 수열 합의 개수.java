import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] newElements = new int[elements.length*2];
        
        for(int i=0; i<2; i++) {
            for(int j=0; j<elements.length; j++) {
                newElements[j+i*elements.length] = elements[j];
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++) {
            for(int j=0; j<elements.length; j++) {
                set.add(Arrays.stream(newElements, j, j+i).sum());
            }
        }            
        return set.size();
    }
}