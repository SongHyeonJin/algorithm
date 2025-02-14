import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++)
            q.offer(s.charAt(i));
        
        for(int i=0; i<s.length(); i++) {
            char c = q.poll();
            q.add(c);
            
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<s.length(); j++) {
                char nc = q.poll();
                q.add(nc);
                
                if(stack.isEmpty()) stack.push(nc);
                else if(nc==')' && stack.peek()=='(') stack.pop();
                else if(nc==']' && stack.peek()=='[') stack.pop();
                else if(nc=='}' && stack.peek()=='{') stack.pop();
                else stack.push(nc);
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}