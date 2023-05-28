import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int wCount = 0;
            int bCount = 0;
            int result = 0;
            int a = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String wordChange = br.readLine();

            for(int j=0; j<word.length(); j++){
                if(word.charAt(j)!=wordChange.charAt(j)){
                    if(word.charAt(j)=='W')wCount++;
                    else bCount++;
                }
            }
            result += (Math.min(wCount,bCount) + Math.abs(wCount-bCount));
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}