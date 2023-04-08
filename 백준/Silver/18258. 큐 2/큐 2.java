import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class MyQueue{
    LinkedList<Integer> myQueue = new LinkedList<>();
    void push(int x){
        myQueue.add(x);
    }

    int size(){
        return myQueue.size();
    }

    int pop(){
        if(!myQueue.isEmpty()){
            int p = myQueue.get(0);
            myQueue.remove(0);
            return p;
        }else return -1;
    }

    int empty(){
        if(myQueue.isEmpty()){
            return 1;
        }else return 0;
    }

    int front(){
        if(!myQueue.isEmpty()){
            return myQueue.get(0);
        }else return -1;
    }

    int back(){
        if(!myQueue.isEmpty()){
            return myQueue.get(size()-1);
        }else return -1;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue();
        for(int i=0; i<n; i++){
            String[] order = br.readLine().split(" ");
            switch (order[0]){
                case "push":
                    q.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    sb.append(q.pop()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.empty()).append("\n");
                    break;
                case "front":
                    sb.append(q.front()).append("\n");
                    break;
                case "back":
                    sb.append(q.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
