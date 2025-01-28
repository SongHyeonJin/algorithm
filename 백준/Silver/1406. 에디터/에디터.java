import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack<String> answer = new Stack<>();
        for (int i = 0; i < str.length(); i++)
            answer.push(String.valueOf(str.charAt(i)));

        Stack<String> stack = new Stack<>();
        int cursor = str.length();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("P")) {
                String plusStr = st.nextToken();
                answer.push(plusStr);
                cursor++;
            }
            else if (command.equals("L")) {
                if (answer.isEmpty()) continue;
                stack.push(answer.pop());
            }
            else if (command.equals("D")) {
                if (answer.size()==cursor) continue;
                if (!stack.isEmpty()) answer.push(stack.pop());
            }
            else if (command.equals("B")) {
                if (answer.isEmpty())continue;
                answer.pop();
                cursor--;
            }
        }
        while (!stack.isEmpty()) {
            answer.push(stack.pop());
        }
        for (String s : answer)
            sb.append(s);
        System.out.println(sb);
    }
}