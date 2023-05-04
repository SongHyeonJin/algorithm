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
        // 주어진 정규표현식으로부터 패턴을 만듭니다.
        Pattern pattern =Pattern.compile("^(c|j|n|m|t|s|l|d|qu)'[aeiouh]");
        int count = words.length;

        for (String word : words){
            // 대상 문자열과 패턴이 일치할 경우 true 반환합니다.
            Matcher matcher = pattern.matcher(word);
            // 대상 문자열과 패턴이 일치하는 경우 true 를 반환하고, 그 위치로 이동합니다.
            while (matcher.find()) count++;
        }
        System.out.println(count);
    }
}