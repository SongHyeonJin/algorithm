import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ArrayList<Word> list = new ArrayList<>();
		
		for (int i = M; i <= N; i++) {
			char[] nums = Integer.toString(i).toCharArray();
			String tmp = "";
			for (int j = 0; j < nums.length; j++) {
				tmp += words[nums[j]-'0'];
			}
			list.add(new Word(i, tmp));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).num + " ");
			if((i+1) % 10 == 0) {
				sb.append("\n");
			}
		}
        
		System.out.println(sb.toString());
	}
	
	static class Word implements Comparable<Word>{
		int num;
		String word;
		public Word(int num, String word) {
			super();
			this.num = num;
			this.word = word;
		}
		@Override
		public int compareTo(Word o) {
			return this.word.compareTo(o.word);
		}
		
	}
}