import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());
        int changeMoney = 1000 - money;
        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for(int i=0; i<coins.length; i++){
            if(changeMoney/coins[i] > 0){
                count += changeMoney/coins[i];
                changeMoney %= coins[i];
            }
        }
        System.out.println(count);
    }
}
