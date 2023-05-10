import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        String word = br.readLine().toUpperCase();

        for(int i=0; i<word.length(); i++){
            int num = word.charAt(i) - 'A';
            arr[num]++;
        }
        int max = -1;
        char ch = '?';
        for(int i=0; i<26; i++){
            if(arr[i] > max){
                max=arr[i];
                ch = (char)(i+'A');
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}