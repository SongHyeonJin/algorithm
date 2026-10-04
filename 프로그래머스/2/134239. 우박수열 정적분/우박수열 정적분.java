import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> yValues = new ArrayList<>();
        double current = k;
        yValues.add(current);
        
        while (current > 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = current * 3 + 1;
            }
            yValues.add(current);
        }
        
        int n = yValues.size() - 1;
        
        double[] areas = new double[n];
        for (int i = 0; i < n; i++) {
            double y1 = yValues.get(i);
            double y2 = yValues.get(i + 1);
            areas[i] = (y1 + y2) / 2.0;
        }
        
        double[] answer = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            int x1 = ranges[i][0];
            int x2 = n + ranges[i][1];
            
            if (x1 > x2) {
                answer[i] = -1.0;
            } else {
                double totalArea = 0;
                for (int j = x1; j < x2; j++) {
                    totalArea += areas[j];
                }
                answer[i] = totalArea;
            }
        }
        
        return answer;
    }
}