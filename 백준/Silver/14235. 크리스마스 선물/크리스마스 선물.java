import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        
		int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) { 
				if(pq.isEmpty()) { 
					sb.append(-1).append("\n");
				} else { 
					sb.append(pq.poll()).append("\n");
				}
			} else { 
				for (int j = 0; j < a; j++) {
					int present = Integer.parseInt(st.nextToken());
					pq.offer(present);
				}
			}
		}
        
        System.out.println(sb.toString());
	}
}