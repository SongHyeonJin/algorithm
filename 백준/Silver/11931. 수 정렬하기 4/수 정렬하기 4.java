import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
 
    int N = Integer.parseInt(br.readLine());
 
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
        Integer.compare(b, a)
    );
 
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      pq.offer(num);
    }
 
    while (!pq.isEmpty()) {
      int num = pq.poll();
      
      sb.append(Integer.toString(num)).append("\n");
    }
 
    System.out.println(sb.toString());
  }
}