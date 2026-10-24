class Solution {
    int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int y = -1, x = -1;
    public int[] solution(String[] park, String[] routes) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    y = i;
                    x = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] r = route.split(" ");
            String direction = r[0];
            int dist = Integer.parseInt(r[1]);
        
            int idx = getDirectionIdx(direction);
            
            if (isWalk(park, y, x, dist, moves[idx])) {
                y += dist * moves[idx][0];
                x += dist * moves[idx][1];
            }
            
        }
        
        return new int[]{y, x};
    }
    
    static boolean isWalk(String[] park, int y, int x, int dist, int[] move) {
        for (int i = 0; i < dist; i++) {
            y += move[0];
            x += move[1];
            
            if (y < 0 || y >= park.length || x < 0 || x >= park[0].length() || park[y].charAt(x) == 'X') {
                return false;
            }
        }
        
        return true;
    }
    
    static int getDirectionIdx(String direction) {
        int idx = 0;
        switch(direction) {
                case ("E") -> {
                    break;
                }
                case ("W") -> {
                    idx = 1;
                    break;
                }
                case ("S") -> {
                    idx = 2;
                    break;
                }
                case ("N") -> {
                    idx = 3;
                    break;
                }
        }
        
        return idx;
    }
    
}