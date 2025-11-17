import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] video;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                video[i][j] = str.charAt(j) - '0';
            }
        }

        br.close();

        cutVideo(0, 0, N);

        System.out.println(sb);
    }

    static void cutVideo(int row, int col, int size){
        if(checkVideo(row, col, size)){
           sb.append(video[row][col]);
           return;
        }

        int mSize = size/2;

        sb.append('(');
        cutVideo(row, col, mSize);
        cutVideo(row, col+mSize, mSize);
        cutVideo(row+mSize, col, mSize);
        cutVideo(row+mSize, col+mSize, mSize);
        sb.append(')');
    }

    static boolean checkVideo(int row, int col, int size){
        int data = video[row][col];

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(video[i][j] != data){
                    return false;
                }
            }
        }
        
        return true;
    }
}