import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> get(int limit){
        int num = 1;
        int current = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (current <= limit){
            current = num * (2 * num -1);
            list.add(current);
            num += 1;
        }
        return list;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = {0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 2};
        int[] dp = new int[N + 1];
        if(N < 13){
            System.out.println(d[N]);
        } else {
            for(int i=0; i<d.length; i++){
                dp[i] =  d[i];
            }
            ArrayList<Integer> list = get(N);
            for(int i=13; i < N + 1; i++){
                int min = Integer.MAX_VALUE;
                for(int num : list){
                    if(num > i) break;
                    min = Math.min(min, dp[i-num]);
                }
                dp[i] = min + 1;
            }
            System.out.println(dp[N]);
        }

    }
}