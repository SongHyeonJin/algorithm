import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Key{
        int x, y;
        public Key(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Map<Character, Key> jaum = new HashMap<>();
    static Map<Character, Key> moum = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letters = br.readLine();

        Key left, right;
        Keyboard();
        left = jaum.get(letters.charAt(0));
        right = moum.get(letters.charAt(2));

        String word = br.readLine();
        int result = 0;

        for(int i=0; i<word.length(); i++){
            char key = word.charAt(i);
            if(jaum.containsKey(key)){
                Key moveJaum = jaum.get(key);
                result += (Math.abs(left.x-moveJaum.x)+Math.abs(left.y-moveJaum.y))+1;
                left = moveJaum;
            } else if (moum.containsKey(key)) {
                Key moveMoum = moum.get(key);
                result += (Math.abs(right.x-moveMoum.x)+Math.abs(right.y-moveMoum.y))+1;
                right = moveMoum;
            }
        }
        System.out.println(result);
    }
    private static void Keyboard(){
        // 1번 째 줄
        jaum.put('q', new Key(0,0));
        jaum.put('w', new Key(1,0));
        jaum.put('e', new Key(2,0));
        jaum.put('r', new Key(3,0));
        jaum.put('t', new Key(4,0));
        moum.put('y', new Key(5,0));
        moum.put('u', new Key(6,0));
        moum.put('i', new Key(7,0));
        moum.put('o', new Key(8,0));
        moum.put('p', new Key(9,0));
        // 2번 째 줄
        jaum.put('a', new Key(0,1));
        jaum.put('s', new Key(1,1));
        jaum.put('d', new Key(2,1));
        jaum.put('f', new Key(3,1));
        jaum.put('g', new Key(4,1));
        moum.put('h', new Key(5,1));
        moum.put('j', new Key(6,1));
        moum.put('k', new Key(7,1));
        moum.put('l', new Key(8,1));
        // 3번 째 줄
        jaum.put('z', new Key(0,2));
        jaum.put('x', new Key(1,2));
        jaum.put('c', new Key(2,2));
        jaum.put('v', new Key(3,2));
        moum.put('b', new Key(4,2));
        moum.put('n', new Key(5,2));
        moum.put('m', new Key(6,2));
    }
}