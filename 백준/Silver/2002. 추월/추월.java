import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> car = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String carNum = br.readLine();
            car.put(carNum, i);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String carNum = br.readLine();

            for (String s : car.keySet()) {
                if (car.get(carNum) > car.get(s)) {
                    cnt++;
                    break;
                }
            }
            car.remove(carNum);
        }
        System.out.println(cnt);
    }
}