class Solution {
    public int[] solution(int brown, int yellow) {
        int totalArea = brown + yellow;
        
        for (int height = 3; height <= totalArea; height++) {
            if (totalArea % height == 0) {
                int width = totalArea / height;
                
                if (width >= height) {
                    if ((width - 2) * (height - 2) == yellow) {
                        return new int[]{width, height};
                    }
                }
            }
        }
        
        return new int[]{};
    }
}