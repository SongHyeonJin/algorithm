class Solution {
    public int solution(String myString, String pat) {
        String a = "";
        for(int i=0; i<myString.length(); i++){
            if(myString.charAt(i) == 'A')
                a += String.valueOf('B');
            else
                a += String.valueOf('A');
        }
        return a.contains(pat) ? 1 : 0;
    }
}