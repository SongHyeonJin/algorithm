class Solution {
    private static final int MAX_BLOCK = 10_000_000;

    public int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];

        for (long i = begin; i <= end; i++) {
            answer[(int) (i - begin)] = getMaxBlock(i);
        }

        return answer;
    }

    private int getMaxBlock(long x) {
        if (x == 1) {
            return 0;
        }
        
        int best = 1;
        
        for (long d = 2; d * d <= x; d++) {
            if (x % d == 0) {
                long pair = x / d;
                
                if (pair <= MAX_BLOCK) {
                    return (int) pair;
                }
                
                if (d <= MAX_BLOCK) {
                    best = (int) d;
                }
            }
        }

        return best;
    }
}