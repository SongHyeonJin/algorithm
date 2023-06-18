import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] names = new String[n][2];

        for(int i=0; i<n; i++){
            String[] name = br.readLine().split(" ");
            names[i][0] = name[0];
            names[i][1] = name[1];
        }

        Arrays.sort(names, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0] == o2[0])
                    return 1;
                else
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        for(int i=0; i<n; i++){
            System.out.println(names[i][0] + " " + names[i][1]);
        }
    }
}