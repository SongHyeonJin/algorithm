import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int MAX = 25 + 10;
    static int n, danji;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void dfs(int y, int x){
        visited[y][x] = true;
        danji++;

        for(int i=0; i<4; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(graph[newY][newX] && !visited[newY][newX]) dfs(newY, newX);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=n; j++){
                graph[i][j] = s.charAt(j-1) == '1';
            }
        }

        ArrayList<Integer> countList = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph[i][j] && !visited[i][j]){
                    danji = 0;
                    dfs(i, j);
                    countList.add(danji);
                }
            }
        }
        System.out.println(countList.size());

        Collections.sort(countList);
        for(int i=0; i<countList.size(); i++){
            System.out.println(countList.get(i));
        }
    }
}