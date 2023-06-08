import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            String sentence = br.readLine();

            Deque<Character> front = new LinkedList<>();
            Stack<Character> back = new Stack<>();
            for (int j = 0; j < sentence.length(); j++) {
                switch (sentence.charAt(j)) {
                    case '<':
                        if (!front.isEmpty()) back.add(front.pollLast());
                        break;
                    case '>':
                        if (!back.isEmpty()) front.addLast(back.pop());
                        break;
                    case '-':
                        if(!front.isEmpty()) front.removeLast();
                        break;
                    default:
                        front.addLast(sentence.charAt(j));
                        break;
                }
            }
            while (!front.isEmpty()) sb.append(front.pollFirst());
            while (!back.isEmpty()) sb.append(back.pop());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}