import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());

        int[] streetTree =new int[N];

        for(int i = 0; i < N; i++){
            streetTree[i] = Integer.parseInt(br.readLine());
        }
		
		int gcd = 0;
		for(int i = 1; i < N; i++)
			gcd = findGCD(streetTree[i] - streetTree[i - 1], gcd);
        
		System.out.println((streetTree[N - 1] - streetTree[0]) / gcd + 1 - N);
	}
	
	private static int findGCD(int a, int b) {
		if(b == 0) return a;
		return findGCD(b, a % b);
	}
}