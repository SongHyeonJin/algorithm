import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] OX = new String[N];

        for(int i=0; i<N; i++){
           OX[i] = br.readLine();
        }

        for(int i=0; i<N; i++){
            int count = 0;
            int sum = 0;
            for(int j=0; j<OX[i].length(); j++){
                if(OX[i].charAt(j)=='O')count++;
                else count = 0;
                sum += count;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}