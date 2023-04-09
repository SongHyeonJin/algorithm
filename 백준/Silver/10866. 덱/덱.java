import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class MyDeque{
    ArrayList<Integer> myDeque = new ArrayList<>();
    void push_front(int x){
        myDeque.add(0, x);
    }
    void push_back(int x){
        myDeque.add(x);
    }

    int size(){
        return myDeque.size();
    }

    int pop_front(){
        if(!myDeque.isEmpty()){
            int p = myDeque.get(0);
            myDeque.remove(0);
            return p;
        }else return -1;
    }

    int pop_back(){
        if(!myDeque.isEmpty()){
            int p = myDeque.get(size()-1);
            myDeque.remove(size()-1);
            return p;
        }else return -1;
    }

    int empty(){
        if(myDeque.isEmpty()){
            return 1;
        }else return 0;
    }

    int front(){
        if(!myDeque.isEmpty()){
            return myDeque.get(0);
        }else return -1;
    }

    int back(){
        if(!myDeque.isEmpty()){
            return myDeque.get(size()-1);
        }else return -1;
    }

}

public class Main{
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyDeque deque = new MyDeque();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "push_front":
                    deque.push_front(Integer.parseInt(order[1]));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(order[1]));
                    break;
                case "pop_front":
                    int b = deque.pop_front();
                    sb.append(b).append("\n");
                    break;
                case "pop_back":
                    int a = deque.pop_back();
                    sb.append(a).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
