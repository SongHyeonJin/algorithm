import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        Loop1: while(true){
            stack.clear();
            String str = br.readLine();

            if(str.equals(".")){  // 온점 하나면 종료
                break;
            }

            for(int i=0; i< str.length(); i++){
                char barket = str.charAt(i); // i 번째 문자. 난 괄호 가지고 할 거라 변수명 괄호로 함.

                if(barket == '(' || barket == '['){
                    stack.push(barket);   // 여는 괄호면 stack 에 담아준다.
                }
                else if (barket == ')') { // 소괄호부터 닫혀야되니 소괄호부터 식을 만들어줌
                    if(stack.empty() || stack.peek() != '('){ // 스택이 비어있거나 여는 소괄호가 아닐 시
                        sb.append("no").append("\n");
                        continue Loop1;
                    }else{
                        stack.pop();  // 여는 소괄호나 여는 대괄호만 넣었기에 대괄호가 아닌 소괄호가 있을 때 뽑는 거임
                    }
                }
                else if (barket == ']') {
                    if(stack.empty() || stack.peek() != '['){
                        sb.append("no").append("\n");
                        continue Loop1;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.empty()){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}