import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int h, w, sum;
    static List<Info> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < w; x++) {
            int h = Integer.parseInt(st.nextToken());
            list.add(new Info(x, h));
        }

        sum = 0;
        int maxHeight = 0;
        Info leftHeight = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Info curHeight = list.get(i);
            if (leftHeight.h <= curHeight.h){
                sum += (curHeight.x - leftHeight.x) * leftHeight.h;
                leftHeight = curHeight;
                maxHeight = i;
            }
        }

        Info rightHeight = list.get(list.size()-1);
        for (int i = 1; i < list.size()-maxHeight; i++) {
            Info curHeight = list.get(list.size()-1-i);
            if(rightHeight.h <= curHeight.h){
                sum += (rightHeight.x - curHeight.x) * rightHeight.h;
                rightHeight = curHeight;
            }
        }

        int x = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i != maxHeight)
                sum -= x*list.get(i).h;
        }
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
