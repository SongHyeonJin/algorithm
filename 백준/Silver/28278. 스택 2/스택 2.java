import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command==1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
                continue;
            }
            if (command==2) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                continue;
            }
            if (command==3) {
                sb.append(stack.size()).append("\n");
                continue;
            }
            if (command==4) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                continue;
            }
            if (command==5)
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
        }
        System.out.println(sb);
    }
}