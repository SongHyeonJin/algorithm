import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int comCnt, netCnt;
    static int[][] computer;
    static boolean[] check;
    static int cnt;

    static void bfs(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()){
            a = queue.poll();
            check[a] = true;
            for(int i=1; i<=comCnt; i++){
                if(!check[i] && computer[a][i] == 1){
                    check[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comCnt = Integer.parseInt(br.readLine());
        netCnt = Integer.parseInt(br.readLine());

        computer = new int[comCnt+1][comCnt+1];
        check = new boolean[comCnt+1];

        for(int i=0; i<netCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int ssang = Integer.parseInt(st.nextToken());
            computer[num][ssang] = computer[ssang][num] = 1;
        }
        bfs(1);
        System.out.println(cnt);
    }
}