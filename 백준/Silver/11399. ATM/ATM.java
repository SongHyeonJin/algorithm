import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] TotalTime = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            TotalTime[i] = Integer.parseInt(st.nextToken());;
        }
        Arrays.sort(TotalTime);
        int time = 0;
        int sum = 0;
        for(int i=0; i<TotalTime.length; i++){
            time += TotalTime[i];
            sum += time;
        }
        System.out.println(sum);
    }
}