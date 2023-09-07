import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String sentence = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean check = false;

        for(int i=0; i<sentence.length(); i++){
            if(sentence.charAt(i) == '<'){
                check = true;
                while (!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(sentence.charAt(i));
            } else if (sentence.charAt(i) == '>') {
                check = false;
                sb.append(sentence.charAt(i));
            } else if (check) {
                sb.append(sentence.charAt(i));
            } else if (!check) {
                if(sentence.charAt(i) == ' '){
                    while (!stack.isEmpty())
                        sb.append(stack.pop());
                    sb.append(sentence.charAt(i));
                } else {
                    stack.push(sentence.charAt(i));
                }
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
    }
}