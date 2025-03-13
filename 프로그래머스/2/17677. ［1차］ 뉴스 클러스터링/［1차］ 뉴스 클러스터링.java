import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = findStr(str1);
        ArrayList<String> list2 = findStr(str2);
        
        if(list1.isEmpty() && list2.isEmpty()) return 65536;
        
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for(String s : list1) {
            if(list2.remove(s)) {
                inter.add(s);
            }
            union.add(s);
        }
        union.addAll(list2);
        
        double jacquard = (double)inter.size()/(double)union.size();
        return (int)(jacquard*65536);
    }
    static ArrayList<String> findStr(String str) {
        ArrayList<String> list = new ArrayList<>();
        str = str.toLowerCase();
        
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i)>='a' && str.charAt(i)<='z' && str.charAt(i+1)>='a' && str.charAt(i+1)<='z') {
                String s = str.substring(i, i + 2);
                list.add(s);
            }
        }
        return list;
    }
}