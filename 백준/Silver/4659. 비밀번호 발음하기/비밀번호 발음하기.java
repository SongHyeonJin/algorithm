import java.io.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
       
      String password;
      char[] pass;
      char prev;
      int count;
      boolean flag;
      while (!(password = br.readLine()).equals("end")) {
         pass = password.toCharArray();
         prev = '.';
         count = 0;
 
         flag = false;
         for (char p : pass) {
            if (isVowel(p)) flag = true;
 
            if (isVowel(p) != isVowel(prev)) count = 1;
            else count++;
 
            if (count > 2 || (prev == p && (p != 'e' && p != 'o'))) {
               flag = false;
               break;
            }
 
            prev = p;
         }
 
         if (flag) sb.append('<').append(password).append("> is acceptable.").append("\n");
         else sb.append('<').append(password).append("> is not acceptable.").append("\n");
      }
 
      System.out.println(sb.toString());
 
   }
 
   public static boolean isVowel(char ch) {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
   }
}