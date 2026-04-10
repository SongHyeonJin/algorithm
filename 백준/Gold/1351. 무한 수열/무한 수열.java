import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static Map<Long, Long> map = new HashMap<>();
    static long N, P, Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map.put(0L, 1L);
        
        find(N);
        
        System.out.println(map.get(N));
    }

    public static long find(long N) {
        if (map.containsKey(N)) return map.get(N);
        
        long first = find((long)Math.floor(N / P));
        long second = find((long)Math.floor(N / Q));
        
        map.put(N, first + second);
        
        return first + second;
    }

}