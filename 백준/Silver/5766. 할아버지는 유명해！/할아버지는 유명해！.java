import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] score;

        while (true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int first = 0;
            int second = 0;

            score = new int[10001];

            if(N==0 && M==0) break;

            // 점수계산
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int idx = Integer.parseInt(st.nextToken());
                    score[idx]++;
                }
            }
            // 1등 점수확인
            for(int i=1; i<10001; i++){
                first = Math.max(score[i], first);
            }

            // 2등 점수확인
            for(int i=1; i<10001; i++){
                if(score[i] != first) second = Math.max(score[i], second);
            }

            // 2등 선수 확인
            for(int i=1; i<10001; i++){
                if(score[i] == second) sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}