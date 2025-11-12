import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		Map<Integer,String> map1 = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String pocketmon = br.readLine();
			map1.put(i, pocketmon);
			map2.put(pocketmon, i);
		}

		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if(49 <= s.charAt(0) && s.charAt(0) <= 57) {
				int key = Integer.parseInt(s);
				sb.append(map1.get(key));
			}
			else {
				
				sb.append(map2.get(s));
			}
			
			sb.append("\n");		
		}
		System.out.println(sb.toString());
	}

}