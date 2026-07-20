class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();
        int count = k;
        
        for (char num : number.toCharArray()) {
            while (count > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) < num) {
                stack.deleteCharAt(stack.length() - 1);
                count--;
            }
            stack.append(num);
        }
        
        return stack.substring(0, number.length() - k);
    }
}