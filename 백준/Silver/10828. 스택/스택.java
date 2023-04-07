import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MyStack{
    ArrayList<Integer> myStack = new ArrayList<>();
    void push(int x){
        this.myStack.add(x);
    }

    int size(){
        return this.myStack.size();
    }

    int pop(){
        if(!this.myStack.isEmpty()){
            int p = this.myStack.get(size()-1);
            this.myStack.remove(size()-1);
            return p;
        }else{
            return -1;
        }
    }

    int empty(){
        if(this.myStack.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }

    int top(){
        if(this.myStack.isEmpty()){
            return -1;
        }else{
            return myStack.get(this.myStack.size()-1);
        }
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder print = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();
        for(int i=0; i<n; i++){
            String[] order = br.readLine().split(" ");
            switch(order[0]){
                case "push":
                    stack.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    print.append(stack.pop()).append('\n');
                    break;
                case "size":
                    print.append(stack.size()).append('\n');
                    break;
                case "empty":
                    print.append(stack.empty()).append('\n');
                    break;
                case "top":
                    print.append(stack.top()).append('\n');
                    break;
            }
        }
        System.out.println(print);
    }
}