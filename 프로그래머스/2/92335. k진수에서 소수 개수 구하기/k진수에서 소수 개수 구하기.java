class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String tmp = "";
        
        while(n!=0) {
            tmp = n%k+tmp;
            n/=k;
        }
        
        String[] str = tmp.split("0");
        for(String s : str) {
            if(s.equals("")) continue;
            long num = Long.parseLong(s);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    static boolean isPrime(long num) {
        if(num<2) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if((num%i==0)) return false;
        }
        return true;
    }
}