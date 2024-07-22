import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int one = 0;
        int zero = 0;
        char preNum = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            char curNum = s.charAt(i);
            if(curNum!=preNum){
                preNum = curNum;
                if(curNum == '0') one++;
                else zero++;
            }
        }
        if(preNum =='0') zero++;
        else one++;
        System.out.println(Math.min(zero, one));
    }
}