import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		long winRate = (long) Math.floor((double)Y * 100 / (double)X );
	
		long left = 1;
		long right = 1000000000;
		long answer = -1;
		while(left <= right) {
			long mid = (left + right) / 2; 
			long newRate = (long)Math.floor((double)(Y+mid)* 100 / (double)(X+mid));
			if(newRate > winRate) {
				answer = mid;
				right = mid - 1;
			}
			else if(newRate <= winRate) {
				left = mid + 1;
			}
		}
        
		System.out.println(answer);
	}
}