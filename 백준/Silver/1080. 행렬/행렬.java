import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] boardA;
	private static int[][] boardB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);

		boardA = new int[N][M];
		boardB = new int[N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				boardA[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
			}
		}

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				boardB[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
			}
		}
		if (N < 3 || M < 3) {
			if (isSameBoard(N, M)) {
				System.out.println("0");
			} else {
				System.out.println("-1");
			}
			return;
		}

		int answer = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (boardA[i][j] != boardB[i][j]) {
					changeSquareBoard(i, j);
					answer++;
				}
			}
		}

		if (!isSameBoard(N, M)) {
			answer = -1;
		}

		System.out.println(answer);
	}

	private static boolean isSameBoard(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boardA[i][j] != boardB[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void changeSquareBoard(int startY, int startX) {
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (boardA[i][j] == 1) {
					boardA[i][j] = 0;
				} else {
					boardA[i][j] = 1;
				}
			}
		}
	}

}