import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String[] splitStr = str.split("");
        List<String> stringList = new ArrayList<>();
        for(int i=splitStr.length-1; i>0; i--){
            splitStr[i-1] += splitStr[i];
            stringList.add(splitStr[i-1]);
        }
        stringList.add(splitStr[splitStr.length-1]);
        Collections.sort(stringList);

        for(String word : stringList){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}