import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A'<=c && c<='Z') {
                sb.append(c);
                continue;
            }
            if (c=='(') {
                stack.push(c);
                continue;
            }
            if (c==')') {
                while (stack.peek()!='(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            while (!stack.isEmpty() && priority(stack.peek())>=priority(c))
                sb.append(stack.pop());
            stack.push(c);
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
    static int priority(char operator) {
        if (operator=='*' || operator=='/') return 2;
        else if (operator=='+' || operator=='-') return 1;
        else return 0;
    }
}