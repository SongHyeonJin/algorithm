import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h, x, y, p, r, count;
    static int[] point;
    static double distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        r = h/2;
        point = new int[2];
        distance = 0;
        count = 0;
        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            point[0] = Integer.parseInt(st.nextToken()) - x;
            point[1] = Integer.parseInt(st.nextToken()) - y;
            if(point[0] >= 0 && point[0] <= w && point[1] >= 0 && point[1] <= h){
                count++;
                continue;
            }
            distance = Math.pow(Math.abs(point[0]), 2) + Math.pow(Math.abs(point[1] - r), 2);
            if(r*r >= distance){
                count++;
                continue;
            }
            distance = Math.pow(Math.abs(point[0] - w), 2) + Math.pow(Math.abs(point[1] - r), 2);
            if(r*r >= distance){
                count++;
                continue;
            }
        }
        System.out.println(count);
    }
}