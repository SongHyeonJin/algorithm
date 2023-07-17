import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        array = new int[N][M];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int rowStart = 0;
        int rowEnd = N-1;
        int colStart = 0;
        int colEnd = M-1;
        while (true){
            int size = (rowEnd - rowStart+1)*2 + (colEnd - colStart+1)*2 - 4;
            change(rowStart, rowEnd, colStart, colEnd, R%size);
            rowStart+=1;
            rowEnd-=1;
            colStart+=1;
            colEnd-=1;
            if(rowStart>rowEnd || colStart>colEnd) break;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void change(int rowStart, int rowEnd, int colStart, int colEnd, int count){
        for(int i=0; i<count; i++){
            int temp = array[rowStart][colStart];

            for(int j=colStart; j<colEnd; j++){
                array[rowStart][j] = array[rowStart][j+1];
            }

            for(int j=rowStart; j<rowEnd; j++){
                array[j][colEnd] = array[j+1][colEnd];
            }

            for(int j=colEnd; j>colStart; j--){
                array[rowEnd][j] = array[rowEnd][j-1];
            }

            for(int j=rowEnd; j>rowStart; j--){
                array[j][colStart] = array[j-1][colStart];
            }
            array[rowStart+1][colStart] = temp;
        }
    }
}
