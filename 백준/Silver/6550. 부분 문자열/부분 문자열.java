import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true){
            String s = br.readLine();
            
            if(s == null) break;
            
            String[] word = s.split(" ");
            String str1 = word[0];
            String str2 = word[1];

            int count = 0;
            int index = 0;
            for(int i = 0; i < str2.length(); i++){
                if(str1.charAt(index) == str2.charAt(i)){
                    index++;
                    count++;
                    
                    if(index == str1.length()) break;
                }
            }

            if(count == str1.length()){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}