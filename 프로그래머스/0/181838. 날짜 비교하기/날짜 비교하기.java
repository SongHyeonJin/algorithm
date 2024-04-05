class Solution {
    public int solution(int[] date1, int[] date2) {
        int answer = 0;
        String str1 = "";
        String str2 = "";
        for(int i=0; i<date1.length; i++){
            str1 += date1[i];
            str2 += date2[i];
        }
        if(Integer.parseInt(str1)<Integer.parseInt(str2)) answer = 1;
        return answer;
    }
}