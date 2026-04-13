import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int num = 0;
        int index = 0;
        boolean flag = true;
        
        while(flag) {
        	num++;
        	
        	String numStr = Integer.toString(num);
        	
        	for(int i = 0; i < numStr.length(); i++) {
        		char c = numStr.charAt(i);
        		
        		if(c == str.charAt(index)) {
        			index++;
        		}
        		
        		if(index == str.length()) {
        			flag = false;
        			break;
        		}
        	}
        }
        
        System.out.println(num);
    }
}