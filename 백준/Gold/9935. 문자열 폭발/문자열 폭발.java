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
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<string.length(); i++){
            int count = 0;
            stack.push(string.charAt(i));
            if(stack.size() >= bomb.length()){
                for(int j=0; j<bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) count++;
                    if(bomb.length() == count){
                        for(int k=0; k<bomb.length(); k++){
                            stack.pop();
                        }
                    }
                }
            }
        }
        for(char c : stack) sb.append(c);
        System.out.println(stack.isEmpty() ? "FRULA" : sb);
    }
}