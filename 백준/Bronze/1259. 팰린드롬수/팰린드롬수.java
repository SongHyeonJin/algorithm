import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String su = br.readLine();
            boolean chk = true;

            if(su.equals("0")) break;
            for(int i=0; i<=su.length()/2; i++){
                if(su.charAt(i) != su.charAt(su.length()-i-1)) chk = false;
            }
            if(chk) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}