import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder front = new StringBuilder();
        StringBuilder end = new StringBuilder();

        String name = br.readLine();
        int[] alphabet = new int[26];
        int oddCheck = 0;
        char mid = '0';

        for (int i = 0; i < name.length(); i++)
            alphabet[name.charAt(i)-'A']++;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i]!=0 && alphabet[i]%2==1) {
                if (oddCheck==0) {
                    oddCheck++;
                    mid = (char)('A'+i);
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
            for (int j = 0; j < alphabet[i]/2; j++) {
                front.append((char) ('A' + i));
                end.insert(0, (char)('A'+i));
            }
        }
        if (oddCheck==0)
            sb.append(front).append(end);
        else
            sb.append(front).append(mid).append(end);
        System.out.println(sb);
    }
}
