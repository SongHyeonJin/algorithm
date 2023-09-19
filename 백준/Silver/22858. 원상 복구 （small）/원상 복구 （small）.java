import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    static int[] arr, changes, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        arr = new int[n+1];
        changes = new int[n+1];

        String[] s1 = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(s1[i-1]);
        }

        String[] s2 = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            changes[i] = Integer.parseInt(s2[i-1]);
        }

        for(int i=0; i<k; i++){
            temp = new int[n+1];
            for(int j=1; j<=n; j++){
                temp[changes[j]] = arr[j];
            }
            arr = temp;
        }

        for(int i=1; i<=n ;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}