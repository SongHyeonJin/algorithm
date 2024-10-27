import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candy = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<candy; i++){
            for(int j=0; j<candy; j++){
                for(int k=0; k<candy; k++){
                    if(i+j+k==candy) 
                        if(i>=j+2)
                            if(i!=0 && j!=0 && k!=0)
                                if(k%2==0) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}