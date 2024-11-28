import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, sum;
    static List<Info> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Info(l, h));
        }
        list.sort(Comparator.comparingInt(o -> o.x));

        sum = 0;
        int maxHeight = 0;

        Info leftHeight = list.get(0);
        for (int i=1; i<list.size(); i++){
            Info curHeight = list.get(i);

            if (leftHeight.h <= curHeight.h){
                sum += (curHeight.x - leftHeight.x) * leftHeight.h;
                leftHeight = curHeight;
                maxHeight = i;
            }
        }

        Info rightHeight = list.get(list.size()-1);
        for (int i=1; i<list.size()-maxHeight; i++){
            Info curHeight = list.get(list.size()-1-i);

            if (rightHeight.h <= curHeight.h){
                sum += (rightHeight.x - curHeight.x) * rightHeight.h;
                rightHeight = curHeight;
            }
        }
        sum += list.get(maxHeight).h;
        System.out.println(sum);
    }
}

class Info{
    int x, h;
    public Info(int x, int h) {
        this.x = x;
        this.h = h;
    }
}