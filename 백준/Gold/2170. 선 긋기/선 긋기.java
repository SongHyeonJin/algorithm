import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		
		int [][] line = new int [N][2];
		for(int i=0;i<N;i++) {
			String [] strs = br.readLine().split(" ");
			line[i][0] = Integer.parseInt(strs[0]);
			line[i][1] = Integer.parseInt(strs[1]);
		}
        
		Arrays.sort(line, (o1, o2) -> {
			if(o1[0]==o2[0])
				return o1[1]-o2[1];
			else 
				return o1[0]-o2[0];
		});
        
		int result = line[0][1] - line[0][0];
		int min = line[0][0];
		int max = line[0][1];
		for(int i = 1;i < N; i++) {
			if(line[i][0] > max) {
				result += line[i][1] - line[i][0];
			}
			else if (max >= line[i][1]) {
				continue;
			}
			else result += line[i][1] - max;
			
			max = Math.max(max, line[i][1]);
		}
        
		System.out.println(result);		
	}
}