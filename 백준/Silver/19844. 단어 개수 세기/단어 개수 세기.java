import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();

        String[] words = sentence.split("[\\s-]");
       
        Pattern pattern =Pattern.compile("^(c|j|n|m|t|s|l|d|qu)(')[aeiouh]");
        int count = words.length;

        for (String word : words){
            Matcher matcher = pattern.matcher(word);
            while (matcher.find()) count++;
        }
        System.out.println(count);
    }
}