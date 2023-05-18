import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] item = new Integer[N];
        for(int i=0; i<N; i++){
            item[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(item, Comparator.reverseOrder());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=1; i<=N; i++){
            stack.push(item[i-1]);
            if(i%3==0)
                stack.pop();
            else
                sum += stack.pop();
        }
        System.out.println(sum);
    }
}