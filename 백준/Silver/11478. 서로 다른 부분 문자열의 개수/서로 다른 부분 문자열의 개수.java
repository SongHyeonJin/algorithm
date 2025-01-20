import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Set<String> hashSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            int idx = i;
            String s = "";
            while (true) {
                if (idx==str.length()) break;
                s += String.valueOf(str.charAt(idx++));
                hashSet.add(s);
            }
        }
        System.out.println(hashSet.size());
    }
}
