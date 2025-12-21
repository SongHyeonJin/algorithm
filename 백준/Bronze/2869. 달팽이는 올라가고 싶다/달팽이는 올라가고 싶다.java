import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());

        long dayDist = A - B;
        long goalDist = V -B;
        
        if(goalDist%dayDist != 0){
            System.out.println(goalDist/dayDist + 1);
        }else{
            System.out.println(goalDist/dayDist);
        }

    }
}