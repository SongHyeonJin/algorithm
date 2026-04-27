import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
        
        int [][] map = new int[r2 - r1 + 1][c2 - c1 + 1];
        int maxNumber = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i-r1][j-c1] = spinalNumber(i,j);
                maxNumber = Math.max(maxNumber, map[i - r1][j - c1]);
            }
        }
        int maxLength = String.valueOf(maxNumber).length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r2 - r1 + 1; i++) {
            for (int j = 0; j < c2 - c1 + 1; j++) {
                sb.append(String.format("%" + maxLength + "d ", map[i][j]));
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static int spinalNumber(int x, int y){
        int depth = Math.max(Math.abs(x), Math.abs(y));

        int startNumber = (2 * depth - 1) * (2 * depth - 1);

        if(x == depth){
            return startNumber + depth * 7 + y;
        }else if(y == -depth){
            return startNumber + depth * 5 + x;
        } else if(x == -depth){
            return startNumber + depth * 3 - y;
        }
        return startNumber + depth - x;
    }
}