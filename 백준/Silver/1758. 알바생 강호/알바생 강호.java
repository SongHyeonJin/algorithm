import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] tip = new Integer[N];
        for(int i=0; i<N; i++){
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip, Comparator.reverseOrder());

        long maxTip = 0;
        for(int i=0; i<N; i++){
            if(tip[i]-i <= 0){
                break;
            }
            maxTip += tip[i]-i;
        }
        System.out.println(maxTip);
    }
}