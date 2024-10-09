class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int cnt = 0;
        int[] tmp = new int[arr.length];
        while(true){
            for(int i=0; i<arr.length; i++){
                tmp[i] = arr[i];
                if(arr[i] >= 50 && arr[i]%2==0) arr[i] = arr[i]/2;
                else if(arr[i] <50 && arr[i]%2==1) arr[i] = arr[i]*2+1;
            }
            for(int i=0; i<arr.length; i++){
                if(tmp[i] == arr[i]) cnt++;
            }
            if(cnt == arr.length)break;
            cnt=0;
            answer++;
        }
        return answer;
    }
}