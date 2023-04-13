import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goodWord = 0;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                if(stack.isEmpty()) stack.push(c);
                else {
                    if(stack.peek()==c) stack.pop();
                    else stack.push(c);
                }
            }
            if(stack.isEmpty()) goodWord++;
        }
        System.out.println(goodWord);
    }
}