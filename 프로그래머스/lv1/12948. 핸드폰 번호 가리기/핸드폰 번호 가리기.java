class Solution {
    public String solution(String phone_number) {
        String front = "";
        String back = "";
        for(int i=0; i<phone_number.length()-4; i++){
            front += "*";
        }
        for(int i=phone_number.length()-4; i<phone_number.length(); i++){
            back += phone_number.charAt(i);
        }
        
        return front + back;
    }
}