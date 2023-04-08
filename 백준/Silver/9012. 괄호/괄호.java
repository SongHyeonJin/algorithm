import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();   // 괄호 하나 가지고 비교할 거라 char 형으로 받아줌

        for(int i=0; i<n; i++){
            String barkets = br.readLine();   // 괄호들 입력하는 것

            for(int j=0; j<barkets.length(); j++){
                char barket = barkets.charAt(j);   // 괄호들을 하나씩 잘라서 반복

                if(barket == '('){           // 하나씩 잘라서 가져온 게 ( 라면
                    stack.push(barket);      // 스택안에 넣는다
                } else{
                    if(stack.size()!=0){     
                        stack.pop();         // ) 이 입력되었을 때 ( 을 뽑아 준다.
                    }else{
                        stack.push(barket);  // ) 가 ( 을 다 뽑았을 때 ( 을 넣어준다.
                        break;
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
            stack.clear();      // 스택을 비워줘야함 아니면 (( 다음 )) 을 입력시 YES 로 반환됨;
        }
    }
}