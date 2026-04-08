import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        String input;
        
        while ((input = br.readLine()).charAt(0) != '-') {
            Stack<Character> stack = new Stack<>();
            int cnt = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '{')
                    stack.push(c);
                else if (stack.isEmpty()) {
                    stack.push('{');
                    cnt++;
                } else
                    stack.pop();
            }

            sb.append(tc++).append(". ").append(cnt + stack.size() / 2).append("\n");
        }

        System.out.println(sb.toString());
    }
}