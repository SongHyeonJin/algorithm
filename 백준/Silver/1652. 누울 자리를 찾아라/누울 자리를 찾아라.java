import java.io.*;

public class Main {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N=Integer.parseInt(br.readLine());
		char input[][] = new char[N][N];
		for(int i=0;i<N;i++) {
			String temp[] = br.readLine().split("");
            for(int j = 0; j < N; j++)
                input[i][j] = temp[j].charAt(0);
		}
		
		int R=0, C=0;
		
        for(int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                if(i + 1 < N) {
                    if (input[i][j] == '.' && input[i+1][j] == '.' && (i + 2 >= N || input[i+2][j] == 'X')) {
                        C += 1;
                    }
                }
                if(j + 1 < N) {
                    if (input[i][j] == '.' && input[i][j + 1] == '.' && (j + 2 >= N || input[i][j + 2] == 'X')) {
                        R += 1;
                    }
                }
            }
        }
        
        System.out.println(R + " " + C);
	}
}