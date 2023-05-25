import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long firstMoney = Integer.parseInt(st.nextToken());
        long money = 0;
        int[] chart = new int[n];

        for(int i=0; i<n; i++){
            chart[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n-1; i++){
            if(money == 0 && chart[i] < chart[i+1]){
                money = firstMoney/chart[i];
                firstMoney-=money*chart[i];
            }
            if(chart[i] > chart[i+1]){
                firstMoney += money * chart[i];
                money = 0;
            }
        }
        firstMoney += money * chart[n-1];
        System.out.println(firstMoney);
    }
}