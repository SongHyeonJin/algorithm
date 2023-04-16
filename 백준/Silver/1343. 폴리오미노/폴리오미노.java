import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String[] strArr = str.split("\\.",-1);
        boolean chk = true;
        int length = 0;
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].length()%2!=0){
                chk = false;
                break;
            }
        }

        if(chk==true){
            for(int i=0; i<strArr.length; i++){
                length = strArr[i].length();
                // split 한 strArr[i]의 갯수가 다 바뀔 때 까지
                while (chk){
                    // strArr[i].length() 가 4이상일 땐 AAAA 로 출력하고 갯수 4개 줄임
                    if(length >= 4){
                        sb.append("AAAA");
                        length = length-4;
                        // strArr[i].length() 가 2이상일 땐 BB 로 출력하고 갯수 4개 줄임
                    }else if( length >= 2){
                        sb.append("BB");
                        length = length-2;
                    }else{
                        break;
                    }
                }
                if(i != strArr.length-1){
                sb.append(".");
                }
            }
        }else{
            sb.append(-1);
        }
        System.out.println(sb);
    }
}
