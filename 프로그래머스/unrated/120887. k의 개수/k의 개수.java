class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int l=i; l<=j; l++){
            String value = String.valueOf(l);
            if(value.contains(String.valueOf(k))) {
                String[] array = value.split("");
                for(String a : array)
                    if(a.equals(String.valueOf(k)))
                        answer++;
            }
        }
        return answer;
    }
}