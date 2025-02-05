import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static ArrayList<Integer>[] tree;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        tree = new ArrayList[k];
        for (int i = 0; i < k; i++)
            tree[i] = new ArrayList<>();

        int size = (int) (Math.pow(2, k)-1);
        arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        search(0, size, 0);

        for (int i = 0; i < k; i++) {
            for (int j : tree[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void search(int start, int end, int depth) {
        if (depth==k) return;
        int mid = (start+end)/2;
        tree[depth].add(arr[mid]);
        search(start, mid-1, depth+1);
        search(mid+1, end, depth+1);
    }
}