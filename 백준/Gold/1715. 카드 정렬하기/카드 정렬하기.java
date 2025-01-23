import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int cardSum = 0;
        while (pq.size()>1) {
            int cardOne = pq.poll();
            int cardTwo = pq.poll();

            cardSum += cardOne+cardTwo;
            pq.add(cardOne+cardTwo);
        }
        System.out.println(cardSum);
    }
}