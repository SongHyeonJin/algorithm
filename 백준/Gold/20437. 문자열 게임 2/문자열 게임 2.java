import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K==1){
                sb.append("1 1").append("\n");
                continue;
            }
            int[] alphabet = new int[26];
            for(int j=0; j<str.length(); j++) alphabet[str.charAt(j) - 'a']++;

            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j=0; j<str.length(); j++){
                if(alphabet[str.charAt(j) - 'a'] < K) continue;
                int count = 1;
                for(int k=j+1; k<str.length(); k++){
                    if(str.charAt(j) == str.charAt(k)) count++;
                    if(count == K){
                        min = Math.min(min, k-j+1);
                        max = Math.max(max, k-j+1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) sb.append("-1").append("\n");
            else sb.append(min + " " + max).append("\n");
        }
        System.out.println(sb.toString());
    }
}