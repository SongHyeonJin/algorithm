import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int min=0, max=0;
        String minA="", minB="", maxA="", maxB="";
        minA = A.replace('6', '5');
        minB = B.replace('6', '5');

        maxA = A.replace('5', '6');
        maxB = B.replace('5', '6');

        min = Integer.parseInt(minA)+Integer.parseInt(minB);
        max = Integer.parseInt(maxA)+Integer.parseInt(maxB);
        System.out.println(min+" "+max);
    }
}
