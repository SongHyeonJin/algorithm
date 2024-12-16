import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n, cost = Integer.MAX_VALUE;
    static int[] ingre;
    static Nutrient[] nutrients;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        nutrients = new Nutrient[n];
        visited = new boolean[n];

        ingre = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i=0; i<n; i++){
            nutrients[i] = Nutrient.of(br.readLine());
        }
        dfs(0, 0, 0, 0, 0, 0);
        if(cost == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(cost);
            for (int a : answer) System.out.print(a+" ");
        }
    }
    static void dfs(int idx, int p, int f, int c, int v, int amount){
        if (ingre[0] <= p && ingre[1] <= f && ingre[2] <= c && ingre[3] <= v) {
            check(amount);
            return;
        }

        if (idx >= n || amount >= cost) return;
        visited[idx] = true;
        dfs(idx+1, p +nutrients[idx].protein, f +nutrients[idx].fat, c +nutrients[idx].crab, v +nutrients[idx].vitamin, amount +nutrients[idx].price);
        visited[idx] = false;
        dfs(idx+1, p, f, c, v, amount);
    }
    private static void check(int amount){
        if (amount < cost){
            cost = amount;
            answer.clear();
            for (int i = 0; i < n; i++)
                if (visited[i]) answer.add(i+1);
        }
    }
}

class Nutrient{
    int protein, fat, crab, vitamin, price;

    public Nutrient(int protein, int fat, int crab, int vitamin, int price) {
        this.protein = protein;
        this.fat = fat;
        this.crab = crab;
        this.vitamin = vitamin;
        this.price = price;
    }

    public static Nutrient of(String food){
        int[] nutrient = Arrays.stream(Arrays.stream(food.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray();

        return new Nutrient(nutrient[0], nutrient[1], nutrient[2], nutrient[3], nutrient[4]);
    }
}
