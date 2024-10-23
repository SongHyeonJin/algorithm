class Solution {
    public String[] solution(String[] picture, int k) {
        int len = picture.length*k;
        int idx = 0;
        String[] answer = new String[len];
        String[] tmp = new String[picture.length];
        String s = "";
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[i].length(); j++){
                for(int l=0; l<k; l++){
                    s += picture[i].charAt(j);
                }
            }
            tmp[i] = s;
            s = "";
        }
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<k; j++) {
                answer[idx++] = tmp[i];
            }
        }
        return answer;
    }
}