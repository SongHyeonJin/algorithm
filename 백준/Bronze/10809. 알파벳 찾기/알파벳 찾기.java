import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];
        for(int i=0; i<alphabet.length; i++){
            alphabet[i] = -1;
        }

        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(alphabet[c-'a']==-1) alphabet[c-'a'] = i;
        }
        for(int count : alphabet){
            System.out.print(count+" ");
        }
    }
}