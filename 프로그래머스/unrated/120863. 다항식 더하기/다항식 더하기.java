class Solution {
    public String solution(String polynomial) {
        int xNum = 0;
        int num = 0;
        String[] strs = polynomial.split(" ");
        
        for(int i=0; i<strs.length; i++){
            if(strs[i].contains("x"))
                xNum += strs[i].equals("x") ? 1 : Integer.parseInt(strs[i].replaceAll("x", ""));
            else if(!strs[i].equals("+"))
                num += Integer.parseInt(strs[i]);
        }
        return (xNum != 0 ? xNum > 1 ? xNum + "x": "x" : "") + (num != 0 ? (xNum != 0 ? " + " : "") + num : xNum == 0 ? "0" : "");
    }
}