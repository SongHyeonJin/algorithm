import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int startPointer =0;
        int endPointer = arr.length-1;
        int answer =0;
        while(startPointer<endPointer){
            int sum = arr[startPointer] + arr[endPointer];

            if(sum == m){
                answer++;
                startPointer++;
            } else if(sum>m){
                endPointer--;
            } else{ //sum<m
                startPointer++;
            }
        }
        
        System.out.println(answer);
    }
}