import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Character> list = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length()==1) cnt++;
            list.add(str.charAt(0));
            int idx = 1;
            for (int j = 1; j < str.length(); j++) {
                if (!list.contains(str.charAt(j))) {
                    list.add(str.charAt(j));
                    idx++;
                } else {
                    if (str.charAt(j) == str.charAt(j-1)) {
                        idx++;
                    } else {
                        continue;
                    }
                }
                if (idx == str.length()) cnt++;
            }
            list.clear();
        }
        System.out.println(cnt);
    }
}