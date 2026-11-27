import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int cameras = 0;
        int lastCameraPos = -30001;

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if (lastCameraPos < start) {
                cameras++;
                lastCameraPos = end;
            }
        }

        return cameras;
    }
}