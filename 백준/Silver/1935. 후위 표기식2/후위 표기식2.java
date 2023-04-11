import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class After {
    ArrayList<Double> MyStack = new ArrayList<>();
        void push(double x) {
        this.MyStack.add(x);
    }
    double pop() {
        if (!this.MyStack.isEmpty()) {
            double p = this.MyStack.get(this.MyStack.size() - 1);
            this.MyStack.remove(this.MyStack.size() - 1);
            return p;
        } else return -1;
    }
    int size() {
        return this.MyStack.size();
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        After after = new After();
        String[] input_data = br.readLine().split(""); // ABC*+DE/-
        Map<Character, Integer> map = new HashMap<>();
        char i='A';
        for (char c = 'A'; c < i + cnt; c++) {
            map.put(c, Integer.parseInt(br.readLine())); // (A,1) (B,2) (C,2)
        }

        double prevVal = 0;
        double nextVal = 0;

        for(String key: input_data) {
            prevVal = 0;
            nextVal = 0;
            switch (key) {
                case "*":
                    prevVal = after.pop();
                    nextVal = after.pop();
                    after.push(nextVal*prevVal);      // A B*C
                    break;
                case "+":
                    //(B * C) + A
                    prevVal = after.pop();
                    nextVal = after.pop();
                    after.push(nextVal + prevVal);
                    break;
                case "/":
                    prevVal = after.pop();
                    nextVal = after.pop();
//                    after.push(nextVal / prevVal);
                    after.push(Math.round(nextVal/prevVal * 100) / 100.0);
                    break;
                case "-":
                    prevVal = after.pop();
                    nextVal = after.pop();
                    after.push(nextVal - prevVal);
                    break;
                default:
                    after.push(map.get(key.charAt(0)));
                    break;
            }
        }
        String val = String.format("%.2f", after.MyStack.get(after.size()-1));
        System.out.println(val);
    } // System.out.printf("%.2f",-);
}