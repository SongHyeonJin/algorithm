import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 음수 ~ 0
        int minusIdx = 0;
        while (minusIdx < n && arr[minusIdx] < 1){
            if(minusIdx + 1 < n && arr[minusIdx+1] < 1){
                answer += arr[minusIdx] * arr[minusIdx+1];
                minusIdx += 2;
            }else {
                answer += arr[minusIdx];
                minusIdx++;
            }
        }
        //양수
        int plusIdx = n-1;
        while(plusIdx >= minusIdx && arr[plusIdx] > 0){
            if(plusIdx -1 >= minusIdx && arr[plusIdx-1] > 1){
                answer += arr[plusIdx] * arr[plusIdx-1];
                plusIdx -= 2;
            }else {
                answer += arr[plusIdx];
                plusIdx--;
            }
        }
        System.out.println(answer);
    }
}