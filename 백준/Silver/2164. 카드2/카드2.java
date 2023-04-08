import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            q.add(i);          // 1 ~ n 번 만큼 돌면서 값을 넣어준다.
        }

        while (q.size() > 1){  // 큐의 크기가 1보다 클 때
            q.poll();          // 큐의 가장 먼저 들어간 값을 빼준다.
            q.add(q.poll());   // 그 다음, 제일 위에 있는 카드를 버려주면서 가장 뒤에 넣어준다.
        }
        System.out.println(q.peek()); // 큐에 남은 값을 출력한다.

    }
}