import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        HashMap<String, Node> child;
        public Node(){
            child = new HashMap<>();
        }
    }
    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int floor = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < floor; j++) {
                String food = st.nextToken();
                if (!cur.child.containsKey(food))
                    cur.child.put(food, new Node());
                cur = cur.child.get(food);
            }
        }
        print(root, "");
        System.out.println(sb);
    }
    static void print(Node cur, String s) {
        ArrayList<String> list = new ArrayList<>(cur.child.keySet());
        Collections.sort(list);
        for (String string : list) {
            sb.append(s).append(string).append("\n");
            print(cur.child.get(string), s+"--");
        }
    }
}