class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] alphabet = {
            "zero", "one", "two",
            "three", "four", "five",
            "six", "seven", "eight", "nine"
        };
        for(int i=0; i<alphabet.length; i++){
            numbers = numbers.replaceAll(alphabet[i], String.valueOf(i));
        }
        answer = Long.parseLong(numbers);
        return answer;
    }
}