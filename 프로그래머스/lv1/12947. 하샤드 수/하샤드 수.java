class Solution {
    public boolean solution(int x) {
        String str = String.valueOf(x);
        String[] strArr = str.split("");
        
        int sum = 0;
        for(int i=0; i<strArr.length; i++){
            sum += Integer.parseInt(strArr[i]);
        }
        return (x%sum==0) ? true : false; 
    }
}