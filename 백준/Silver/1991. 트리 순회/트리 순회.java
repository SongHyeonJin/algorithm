import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static Node[] tree;
    static void preorder(Node node) {
        if (node==null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    static void inorder(Node node) {
        if (node==null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }
    static void postorder(Node node) {
        if (node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parenValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[parenValue-'A']==null) tree[parenValue-'A'] = new Node(parenValue);
            if (leftValue!='.') {
                tree[leftValue-'A'] = new Node(leftValue);
                tree[parenValue-'A'].left = tree[leftValue-'A'];
            }
            if (rightValue!='.') {
                tree[rightValue-'A'] = new Node(rightValue);
                tree[parenValue-'A'].right = tree[rightValue-'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }
}