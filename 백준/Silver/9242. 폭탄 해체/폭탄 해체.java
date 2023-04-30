import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] code = new String[5];
        int num = 0;
        for (int i = 0; i < 5; i++) {
            code[i] = br.readLine();
        }
        for (int i = 0; i < code[0].length(); i += 4) {
            int digit = getDigit(code, i);
            if (digit == -1) {
                System.out.println("BOOM!!");
                return;
            }
            num = num * 10 + digit;
        }
        if (num % 6 == 0) {
            System.out.println("BEER!!");
        } else {
            System.out.println("BOOM!!");
        }
    }

    private static int getDigit(String[] code, int index) {
        String[] digitCode = new String[5];
            for (int i = 0; i < 5; i++) {
                digitCode[i] = (code[i].length() < index + 3) ? code[i].substring(index) : code[i].substring(index, index + 3);
            }

        for (int i = 0; i < 10; i++) {
            if (digitCode[0].equals(DIGIT[i][0]) && digitCode[1].equals(DIGIT[i][1])
                    && digitCode[2].equals(DIGIT[i][2]) && digitCode[3].equals(DIGIT[i][3])
                    && digitCode[4].equals(DIGIT[i][4])) {
                return i;
            }
        }
        return -1;
    }

    private static final String[][] DIGIT = {
            {"***", "* *", "* *", "* *", "***"}, // 0
            {"  *", "  *", "  *", "  *", "  *"}, // 1
            {"***", "  *", "***", "*  ", "***"}, // 2
            {"***", "  *", "***", "  *", "***"}, // 3
            {"* *", "* *", "***", "  *", "  *"}, // 4
            {"***", "*  ", "***", "  *", "***"}, // 5
            {"***", "*  ", "***", "* *", "***"}, // 6
            {"***", "  *", "  *", "  *", "  *"}, // 7
            {"***", "* *", "***", "* *", "***"}, // 8
            {"***", "* *", "***", "  *", "***"}  // 9
    };
}