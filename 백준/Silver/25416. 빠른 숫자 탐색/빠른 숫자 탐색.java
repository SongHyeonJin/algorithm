import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[5][5];
    static int[][] visited = new int[5][5];
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int nowX, nowY, answer = 0;
    static class Node {
        int x, y, cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        nowX = Integer.parseInt(st.nextToken());
        nowY = Integer.parseInt(st.nextToken());
        
        Move(nowX, nowY);
        
        if (answer == 0) answer = -1;
        
        System.out.println(answer);
    }
    
    static void Move(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (map[cur.x][cur.y] == 1) {
                answer = cur.cnt;
                return;
            }
            
            for(int i=0; i<4; i++) {
                int newX = cur.x + moveX[i];
                int newY = cur.y + moveY[i];
                
                if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5 || visited[newX][newY] != 0 || map[newX][newY] == -1) continue;
                
                visited[newX][newY] = cur.cnt + 1;
                q.offer(new Node(newX, newY, cur.cnt + 1));
            }
        }
    }
}