import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            long num = Long.parseLong(br.readLine());
            for(int j=2; j<1000001; j++){
                if(num%j==0){
                    sb.append("NO\n");
                    break;
                }
                else if(j==1000000) sb.append("YES\n");
            }
        }
        System.out.println(sb.toString());
    }
}