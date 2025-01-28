import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Target {
        int importance;
        boolean check;

        public Target(int importance, boolean check) {
            this.importance = importance;
            this.check = check;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Queue<Target> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                int importance = Integer.parseInt(st.nextToken());
                arr[j] = importance;
                if (j==m) q.offer(new Target(importance, true));
                else q.offer(new Target(importance, false));
            }
            Arrays.sort(arr);
            int cnt=0;
            int index=arr.length-1;
            while (!q.isEmpty()) {
                if (arr[index]==q.peek().importance) {
                    boolean check = q.peek().check;
                    q.poll();
                    cnt++;
                    index--;
                    if (check) break;
                } else {
                    q.offer(q.poll());
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
