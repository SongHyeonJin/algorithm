import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> colMap = new HashMap<>();
        colMap.put("code", 0);
        colMap.put("date", 1);
        colMap.put("maximum", 2);
        colMap.put("remain", 3);
        
        int extIdx = colMap.get(ext);
        int sortIdx = colMap.get(sort_by);
        
        List<int[]> filteredList = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filteredList.add(row);
            }
        }
        
        filteredList.sort((o1, o2) -> Integer.compare(o1[sortIdx], o2[sortIdx]));
        
        int[][] answer = new int[filteredList.size()][4];
        for (int i = 0; i < filteredList.size(); i++) {
            answer[i] = filteredList.get(i);
        }
        
        return answer;
    }
}