import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static boolean[] visited;
    static ArrayList<Integer> list;
    static int n, result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        nums = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(list, 0);

        System.out.println(result);
    }

    public static void dfs(ArrayList<Integer> list, int count) {
        if(count == n){
            result = Math.max(getResult(list), result);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                dfs(list, count+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    public static int getResult(ArrayList<Integer> list){
        int sum = 0;
        for(int i = 0; i < n - 1; i++){
            sum += Math.abs(list.get(i) - list.get(i+1));
        }
        
        return sum;
    }
}