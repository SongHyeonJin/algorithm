import java.util.*;

class Solution {
    public int solution(int[] array) {
//         Arrays.sort(array);
        
//         int answer = 0;
//         // 갯수를 담아주기 위해. 즉 여러개일 경우를 대비.
//         int max = 0;
//         // 배열에 값이 1개이면 그 값을 출력하기 위해 선언
//         int freqNum = array[0];
//         // 갯수 카운트 1개 있으면 1이니 1부터 시작.
//         int cnt = 1;
        
//         for(int i=1; i<array.length; i++){
//             if(array[i] == array[i-1]){
//                 cnt++;
//                 if(cnt > max){
//                     max = cnt;
//                     freqNum = array[i];
//                 }else if(cnt == max){
//                     freqNum = -1;
//                 }
//             }else{
//                 cnt = 1;
//             }
//         }
//         answer = freqNum;
        
//         return answer;
        int answer = 0;
int arr_max = 0;

for (int i = 0; i < array.length; i++) {
    if (array[i] > arr_max) {
        arr_max = array[i];
    }
}
        int[] count = new int[arr_max + 1];
int max = 0;

int n = 0;
int mode = 0;

for (int i = 0; i < array.length; i++) {
    count[array[i]]++;
}
        for (int i = 0; i < count.length; i++) {
    if (count[i] > max) {
        max = count[i];
        answer = i;
    }
}

for (int i = 0; i < count.length; i++) {
    mode++;

    if (count[i] == max) {
        n++;
    }
}

if (n > 1) answer = -1;

return answer;
    }
}