import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];

        for(int i=0; i<N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope, Collections.reverseOrder());

        int maxWeight = 0;
        for(int i=0; i<N; i++){
            if(rope[i]*(i+1)>maxWeight) maxWeight = rope[i]*(i+1);
        }
        System.out.println(maxWeight);
    }
}