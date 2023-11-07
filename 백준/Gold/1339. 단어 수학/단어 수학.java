import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        int answer = 0;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                alphabet[c-'A'] += (int) Math.pow(10, s.length() - j - 1);
            }
        }
        Arrays.sort(alphabet);

        int num = 9;
        for(int i=25; i>=0; i--){
            if(alphabet[i] == 0) continue;
            answer += (alphabet[i] * num);
            num--;
        }
        System.out.println(answer);
    }
}