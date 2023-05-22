import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            int a = num%42;
            arr[i] = a;
        }
        for(int data : arr){
            if(!nums.contains(data)) nums.add(data);
        }
        System.out.println(nums.size());
    }
}