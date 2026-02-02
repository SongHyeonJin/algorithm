import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String[] s = pattern.split("\\*");
        String head = s[0];
        String tail = s[1];
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            if(input.length() < head.length() + tail.length()){
                System.out.println("NE");
                continue;
            }
            if(input.substring(0,head.length()).equals(head)){
                if(input.substring(input.length() - tail.length(),input.length()).equals(tail)){ // 뒤의 문자가 tail과 일치할 때 
                    System.out.println("DA");
                    continue;
                }
            }
            System.out.println("NE");
        }
    }
}