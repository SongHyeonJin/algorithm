import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 문자열 분리

        int n = Integer.parseInt(st.nextToken());
        int remove = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);  // 1 부터 입력한 숫자 n 까지 넣어줌. 
        }
        
        sb.append("<");  // 뽑기 전에 < 추가해 열어줌.
        while (queue.size()>1){  // 숫자가 1개가 남았을 때 출력해줘야되니 1개 초과 일 때 까지 돌려줌.
            for(int i=1; i<remove; i++){
                queue.add(queue.poll()); // remove 번째 값을 출력할 때 까지 뽑아서 뒤로 넣어줌.
            }
           sb.append(queue.poll()).append(", ");  // remove 번째 값을 한 씩 출력하면서 ,(스페이스) 를 추가해줌.
        }
        sb.append(queue.poll()).append(">");  // 마지막 값 뽑아주면서 > 추가해 닫아줌.
        System.out.println(sb);
    }
}