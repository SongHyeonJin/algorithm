import java.util.*;

class Solution {
    
    private static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        int n = line.length;
        
        for (int i = 0; i < n; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long c = line[i][2];

            for (int j = i + 1; j < n; j++) {
                long d = line[j][0];
                long e = line[j][1];
                long f = line[j][2];
                
                long denominator = a * e - b * d;
                
                if (denominator == 0) continue;
                
                long numeratorX = b * f - c * e;
                long numeratorY = c * d - a * f;
                
                if (numeratorX % denominator != 0 || numeratorY % denominator != 0) continue;

                long x = numeratorX / denominator;
                long y = numeratorY / denominator;

                points.add(new Point(x, y));
                
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }
        
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        
        char[][] board = new char[height][width];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        for (Point p : points) {
            int nx = (int) (p.x - minX);
            int ny = (int) (maxY - p.y);
            board[ny][nx] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(board[i]);
        }

        return answer;
    }
}