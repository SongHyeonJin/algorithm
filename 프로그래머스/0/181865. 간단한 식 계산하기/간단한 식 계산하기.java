class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] operators = binomial.split(" ");
        if(operators[1].equals("+"))
            answer = Integer.parseInt(operators[0]) + Integer.parseInt(operators[2]);
        else if(operators[1].equals("-"))
            answer = Integer.parseInt(operators[0]) - Integer.parseInt(operators[2]);
        else if(operators[1].equals("*"))
            answer = Integer.parseInt(operators[0]) * Integer.parseInt(operators[2]);
        return answer;
    }
}