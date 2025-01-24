import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        LinkedList<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) queue.offer(i);

        int cnt=0;
        for (int i = 0; i < m; i++) {
            int targetIdx = queue.indexOf(arr[i]);
            int middleIdx;

            if (queue.size()%2==0) middleIdx=queue.size()/2-1;
            else middleIdx=queue.size()/2;
            
            if (targetIdx<=middleIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    queue.offerLast(queue.pollFirst());
                    cnt++;
                }
            } else {
                for (int j = 0; j < queue.size()-targetIdx; j++) {
                    queue.offerFirst(queue.pollLast());
                    cnt++;
                }
            }
            queue.pollFirst();
        }
        System.out.println(cnt);
    }
}
