import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i=1;i<=N;i++)
            dq.addLast(i);
        
        int count = 1;
        while(!dq.isEmpty()){
            if(count % 2 == 1)
                sb.append(dq.pollFirst()).append(" ");
            else{
                int temp = dq.pollFirst();
                dq.addLast(temp);
            }
            count++;
        }
        
        System.out.println(sb.toString());
    }
}