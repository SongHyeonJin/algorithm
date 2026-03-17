import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
            
        Arrays.sort(arr);
        
        int mid = N / 2;
        if(N % 2 == 0){
            int sum1 = 0;
            for(int i = 0; i < N; i++) {
                sum1 += Math.abs(arr[i] - arr[mid]);
            }    
            
            int sum2 = 0;
            mid--;
            for(int i = 0; i < N; i++) {
                sum2 += Math.abs(arr[i] - arr[mid]);
            }
                
            if(sum1 > sum2) mid++;
        }
        
        System.out.println(arr[mid]);
    }
}