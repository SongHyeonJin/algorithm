import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int switchCnt = Integer.parseInt(br.readLine());
        int[] switchStatus = new int[switchCnt];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<switchCnt; i++){
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());

        for(int i=0; i<studentCnt; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for(int j=0; j<switchCnt; j++)
                    if((j+1) % switchNum == 0)
                        switchStatus[j] = switchStatus[j] == 0? 1: 0;
            }
            else {
                switchStatus[switchNum - 1] = switchStatus[switchNum - 1] == 0 ? 1 : 0;
                for(int j=1; j<switchCnt/2; j++) {
                    if(switchNum - 1 + j >= switchCnt || switchNum - 1 - j < 0)
                        break;
                    if(switchStatus[switchNum - 1 - j] == switchStatus[switchNum - 1 + j]) {
                        switchStatus[switchNum - 1 - j] = switchStatus[switchNum - 1 - j] == 0 ? 1 : 0;
                        switchStatus[switchNum - 1 + j] = switchStatus[switchNum - 1 + j] == 0? 1 : 0;
                    }
                    else break;
                }
            }
        }

        for(int i=0; i<switchCnt; i++){
            System.out.print(switchStatus[i]+ " ");
            if((i+1)%20==0) System.out.println();
        }
    }
}