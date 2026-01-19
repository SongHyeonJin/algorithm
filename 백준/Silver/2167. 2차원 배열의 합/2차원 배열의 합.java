import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    		
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[N][M];
    	int[][] prefix = new int[N+1][M+1];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=M;j++) {
    			prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i-1][j-1]; 
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int K = Integer.parseInt(st.nextToken());
    	for(int t=0;t<K;t++) {
    		st = new StringTokenizer(br.readLine());
    		int i = Integer.parseInt(st.nextToken());
    		int j = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
            sb.append(prefix[x][y] - prefix[i-1][y] - prefix[x][j-1] + prefix[i-1][j-1]).append("\n");
    	}
    	
    	System.out.println(sb.toString());
	}
}