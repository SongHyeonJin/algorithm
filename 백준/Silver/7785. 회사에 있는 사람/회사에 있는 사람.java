import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, String> people = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter")) {
                people.put(name, state);
            }
            else if (state.equals("leave")) {
                people.remove(name);
            }
        }

        List<String> list = new ArrayList<>(people.keySet());
        list.sort(Comparator.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }
}