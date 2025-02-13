class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int y = -1,x = -1;
        int yLen = park.length;
        int xLen = park[0].length();
        
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
            int curY = y;
            int curX = x;

            switch (direction) {
                case "E" -> {
                    boolean flag = true;
                    for (int j = 1; j <= dis; j++) {
                        curX++;
                        if (curX >= xLen) {
                            flag = false;
                            break;
                        }
                        if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        x = curX;
                }
                case "S" -> {
                    boolean flag = true;
                    for (int j = 1; j <= dis; j++) {
                        curY++;
                        if (curY >= yLen) {
                            flag = false;
                            break;
                        }
                        if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        y = curY;
                }
                case "W" -> {
                    boolean flag = true;
                    for (int j = 1; j <= dis; j++) {
                        curX--;
                        if (curX < 0) {
                            flag = false;
                            break;
                        }
                        if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        x = curX;
                }
                case "N" -> {
                    boolean flag = true;
                    for (int j = 1; j <= dis; j++) {
                        curY--;
                        if (curY < 0) {
                            flag = false;
                            break;
                        }
                        if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        y = curY;
                }
            }
        }
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
}