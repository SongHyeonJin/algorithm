import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            String[] info = br.readLine().split(" ");
            int num = Integer.parseInt(info[0]);
            int start = Integer.parseInt(info[1]);
            int end = Integer.parseInt(info[2]);
            times.add(new Time(num, start, end));
        }
        
        Collections.sort(times);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = 1;

        for (int i = 0; i < n; i++){
            while (!q.isEmpty() && q.peek()<=times.get(i).start){
                q.poll();
            }
            
            q.offer(times.get(i).end);
            max = Math.max(max, q.size());
        }


        System.out.println(max);
    }

}


class Time implements Comparable<Time>{
    int num;
    int start;
    int end;

    @Override
    public int compareTo(Time t){
        if (this.start == t.start)return this.end - t.end;
        return this.start - t.start;
    }

    public Time(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }
}