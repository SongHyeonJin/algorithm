import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int num = numbers[0] * numbers[1];
        int num2 = numbers[numbers.length-2] * numbers[numbers.length-1];
        return num > num2 ? num : num2;
    }
}