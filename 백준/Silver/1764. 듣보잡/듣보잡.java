import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> people = new HashSet<>();
        for(int i=0; i<N; i++){
            people.add(br.readLine());
        }

        Set<String> dbj = new TreeSet<>();
        for(int i=0; i<M; i++){
            String person = br.readLine();
            if(people.contains(person)) dbj.add(person);
        }

        System.out.println(dbj.size());
        for(String person : dbj) System.out.println(person);
    }
}