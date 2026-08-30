import java.util.*;

class Solution {
    static class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        if (!hasTarget(target, words)) {
            return 0;
        }
        
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            if (current.word.equals(target)) {
                return current.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangeable(current.word, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], current.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean hasTarget(String target, String[] words) {
        for (String w : words) {
            if (w.equals(target)) return true;
        }
        return false;
    }

    private boolean isChangeable(String w1, String w2) {
        int diffCount = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) return false;
        }
        return diffCount == 1;
    }
}