import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int binarySearch(ArrayList<Integer> sum, int target){
        int left = 0, right = sum.size()-1, mid, answer = -1;
        while (left <= right){
            mid = (left + right) / 2;
            if(sum.get(mid) <= target){
                answer = mid;
                left = mid+1;
            } else right = mid-1;
        }
        return answer;
    }
    static int n, c;
    static ArrayList<Integer> weight1, weight2, sum1, sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        weight1 = new ArrayList<>();
        weight2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            if(i < n/2) weight1.add(Integer.parseInt(st.nextToken()));
            else weight2.add(Integer.parseInt(st.nextToken()));
        }

        sum1 = new ArrayList<>();
        sum2 = new ArrayList<>();

        dfs(0, 0, weight1, sum1);
        dfs(0, 0, weight2, sum2);

        Collections.sort(sum2);
        int answer = 0;

        for(int i=0; i<sum1.size(); i++){
            int searchValue = c - sum1.get(i);
            answer += binarySearch(sum2, searchValue) + 1;
        }
        System.out.println(answer);
    }
    static void dfs(int idx, int sum, ArrayList<Integer> weight, ArrayList<Integer> answer){
        if(sum > c) return;
        if(idx == weight.size()){
            answer.add(sum);
            return;
        }

        // 무게 넣을 때
        dfs(idx+1, sum+weight.get(idx), weight, answer);
        // 무게 안넣을 때
        dfs(idx+1, sum, weight, answer);
    }
}