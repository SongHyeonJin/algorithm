class Solution {
    static int answer, target;
    static int[] numbers;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }
    static void dfs(int depth, int sum){
        if(depth == numbers.length){
            if(target == sum) answer++;
        }else{
            dfs(depth+1, sum+numbers[depth]);
            dfs(depth+1, sum-numbers[depth]);
        }
    }
}