import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] pw = br.readLine().toCharArray();
        int[] curNum = new int[4];
        check = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) check[i] = Integer.parseInt(st.nextToken());

        int answer=0;
        for (int i = 0; i < p; i++) {
            if (pw[i]=='A') curNum[0]++;
            if (pw[i]=='C') curNum[1]++;
            if (pw[i]=='G') curNum[2]++;
            if (pw[i]=='T') curNum[3]++;
        }
        if (checkNum(curNum)) answer++;

        for (int j = p; j < s; j++) {
            int i=j-p;

            if (pw[i]=='A') curNum[0]--;
            if (pw[i]=='C') curNum[1]--;
            if (pw[i]=='G') curNum[2]--;
            if (pw[i]=='T') curNum[3]--;

            if (pw[j]=='A') curNum[0]++;
            if (pw[j]=='C') curNum[1]++;
            if (pw[j]=='G') curNum[2]++;
            if (pw[j]=='T') curNum[3]++;

            if (checkNum(curNum)) answer++;
        }
        System.out.println(answer);
    }
    static boolean checkNum(int[] num) {
        for (int i = 0; i < 4; i++) {
            if (num[i]<check[i]) return false;
        }
        return true;
    }
}