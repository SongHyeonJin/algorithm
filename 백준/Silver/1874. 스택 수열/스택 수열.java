import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for(int i=0; i<size; i++){
            int n = Integer.parseInt(br.readLine());
            if(n>num){
                for(int j=num+1; j<=n; j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                num = n;
            }
            if(stack.get(stack.size()-1) == n){
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        if(stack.size() > 0) System.out.println("NO");
        else System.out.println(sb);
    }
}