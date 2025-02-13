class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int y=-1, x=-1;
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j)=='S') {
                    y = i;
                    x = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] s = route.split(" ");
            String direction = s[0];
            int dis = Integer.parseInt(s[1]);
            
            int index = getDirectionIndex(direction);
            
            if(isWalk(park, y, x, dis, moves[index])) {
                y += dis*moves[index][1];
                x += dis*moves[index][0];
            }
        
        }
        
        return new int[]{y, x};
    }
    
    static boolean isWalk(String[] park, int y, int x, int dis, int[] move) {
        for(int i=0; i<dis; i++) {
            y += move[1];
            x += move[0];
            if(0>y || y>=park.length || 0>x || x>=park[0].length() || park[y].charAt(x)=='X') return false;
        }
        
        
        return true;
    }
    
    static int getDirectionIndex(String direction) {
        int index = 0;
        switch(direction) {
            case "E" -> { 
                break;
            }
            case "W" -> {
                index = 1;
                break;
            }
            case "S" -> {
                index = 2;
                break;
            }
            case "N" -> {
                index = 3;
                break;
            }
        }
        return index;
    }
}