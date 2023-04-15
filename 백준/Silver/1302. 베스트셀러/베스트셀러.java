import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> books = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int max = 0;

        for(int i=0; i<N; i++){
            // 책 입력
            String book = br.readLine();
            // 책이 들어 있다면 책을 넣고 갯수 +1 해줌
            if(books.containsKey(book)) books.put(book, books.get(book)+1);
            // 맵에 책이 없다면 책을 넣고 1개 입력
            else books.put(book, 1);
            // 가장 많이 팔린 책 갯수를 max 에 넣어줌
            max = Math.max(max, books.get(book));
        }

        List<String> list = new ArrayList<>();
        // entrySet()은 키-값이 묶인 데이터를 가져옴
        for(Map.Entry<String, Integer> entry : books.entrySet()){ // 많은 양의 데이터 가져올 땐 ketSet()보다 좋음
            if(entry.getValue()==max) list.add(entry.getKey()); // 가장 많이 팔린책들이 겹친다면 책이름을 list에 넣어줌
        }
        Collections.sort(list); // 갯수가 같을 때 오름차순 정렬
        System.out.println(list.get(0));
    }
}