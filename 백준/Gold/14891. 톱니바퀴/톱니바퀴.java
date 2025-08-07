import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][] gears = new int[4][8]; // 톱니바퀴 4개
    static int[] dir; // 회전 방향 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 상태 입력
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearIdx = Integer.parseInt(st.nextToken()) - 1;
            int rotateDir = Integer.parseInt(st.nextToken());

            dir = new int[4];
            dir[gearIdx] = rotateDir;

            // 왼쪽 확인
            for (int i = gearIdx - 1; i >= 0; i--) {
                if (gears[i][2] != gears[i + 1][6]) {
                    dir[i] = -dir[i + 1];
                } else break;
            }

            // 오른쪽 확인
            for (int i = gearIdx + 1; i < 4; i++) {
                if (gears[i - 1][2] != gears[i][6]) {
                    dir[i] = -dir[i - 1];
                } else break;
            }

            // 회전 실행
            for (int i = 0; i < 4; i++) {
                if (dir[i] != 0) rotate(i, dir[i]);
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) score += (1 << i);
        }

        System.out.println(score);
    }

    private static void rotate(int idx, int d) {
        if (d == 1) { // 시계 방향
            int temp = gears[idx][7];
            for (int i = 7; i > 0; i--) {
                gears[idx][i] = gears[idx][i - 1];
            }
            gears[idx][0] = temp;
        } else { // 반시계 방향
            int temp = gears[idx][0];
            for (int i = 0; i < 7; i++) {
                gears[idx][i] = gears[idx][i + 1];
            }
            gears[idx][7] = temp;
        }
    }
}