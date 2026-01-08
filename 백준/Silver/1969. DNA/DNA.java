import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String [] str = new String[N];
        for(int i = 0 ; i < N ; i++){
            str[i] = br.readLine();
        }
        
        String answer = "";
        int minSum = 0;
        for(int i = 0 ; i < M ; i++){
            int [] cnt = new int [100];
            for(int j = 0 ; j < N ; j++){
                cnt[str[j].charAt(i)]++;
            }
            int max = 0;
            char maxChar = 'a';
            for(char j = 'A' ; j <= 'Z' ; j++){
                if(cnt[j] > max){
                    max = cnt[j];
                    maxChar = j;
                }
            }
            minSum += (N-max);
            answer += maxChar;
        }
        
        System.out.println(answer);
        System.out.println(minSum);
    }
}