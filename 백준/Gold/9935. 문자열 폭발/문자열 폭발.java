import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String string = br.readLine();
        String bomb = br.readLine();
        int string_len = string.length();
        int bomb_len = bomb.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string_len; i++) {
            stack.push(string.charAt(i));
            if (stack.size() >= bomb_len) {
                boolean flag = true;
                for (int j = 0; j < bomb_len; j++) {
                    if (stack.get(stack.size() - bomb_len + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int k = 0; k < bomb_len; k++) {
                        stack.pop();
                    }
                }
            }
        }
        for (char c : stack) sb.append(c);
        System.out.println(stack.isEmpty() ? "FRULA" : sb);
    }
}