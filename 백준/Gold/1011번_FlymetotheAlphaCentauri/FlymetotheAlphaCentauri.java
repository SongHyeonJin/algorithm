package algorithm;

import java.util.Scanner;

public class FlymetotheAlphaCentauri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        for(int i=0; i<k; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = y-x;
            int root= (int) Math.sqrt(distance);

            if(root*root == distance){
                System.out.println(2*root-1);
            }else if (root*root+root>= distance){
                System.out.println(2*root);
            }else{
                System.out.println(2*root+1);
            }
        }
    }
}
