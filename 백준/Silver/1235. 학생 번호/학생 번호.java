import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] students = new String[N];
        int answer = 0;

        for(int i = 0; i < N; i++){
            students[i] = br.readLine();
        }
        
        int len = students[0].length();
        for(int i = 1; i <= len; i++) {
            Set<String> check = new HashSet<>();
            for (String student : students) {
                String tmp = student.substring(len - i, len);
                check.add(tmp);
            }
            
            if(check.size() == N){
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}