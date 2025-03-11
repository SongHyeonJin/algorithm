import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sb.append(isPalindrome(0, s.length()-1, s.toCharArray(), 0)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int isPalindrome(int left, int right, char[] arr, int delCnt) {
        while (left<right) {
            if(arr[left]!=arr[right]) {
                if(delCnt==0) {
                    if(isPalindrome(left+1, right, arr, 1)==0 ||
                    isPalindrome(left, right-1, arr, 1)==0) {
                        return 1;
                    }
                    else return 2;
                }
                else return 2;
            }
            else {
                left++;
                right--;
            }
        }
        return 0;
    }
}