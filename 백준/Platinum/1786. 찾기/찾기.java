import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        kmp(T, P);
        System.out.println(list.size());
        for (int i : list)
            System.out.println(i);
    }
    static int[] findLps(String p) {
        int left=0, right=1;
        int[] lps = new int[p.length()];
        while (right<p.length()) {
            if (p.charAt(left) == p.charAt(right)) {
                left++;
                lps[right] = left;
                right++;
            }
            else if (left==0) right++;
            else left = lps[left-1];
        }
        return lps;
    }
    static void kmp(String t, String p) {
        int i=0, j=0;
        int[] lps = findLps(p);
        while (i<t.length()) {
            if (t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j==p.length()) {
                    list.add(i-j+1);
                    j = lps[j-1];
                }
            }
            else if (j==0) i++;
            else j = lps[j-1];
        }
    }
}
