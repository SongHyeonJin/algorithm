class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        for(int i=1 ; i<=count; i++){
            total += i*price; 
        }
        if(money<total){
            return total-money;
        }else return 0;
    }
}