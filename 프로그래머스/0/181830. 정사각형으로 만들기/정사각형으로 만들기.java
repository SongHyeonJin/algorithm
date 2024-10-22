import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int row = 1, column = 1;
        for(int i=0; i<arr.length; i++){
            row = i;
            for(int j=0; j<arr[i].length; j++){
                column = j;
            }
        }
        if(row>column){
            int[][] answer = new int[row+1][row+1];
            for(int i=0; i<=row; i++){
                for(int j=0; j<=row; j++){
                    if(j<=column) answer[i][j] = arr[i][j];
                    else answer[i][j] = 0;
                }   
            }
            return answer;
        }else{
            int[][] answer = new int[column+1][column+1];
            for(int i=0; i<=column; i++){
                if(i<=row){
                    for(int j=0; j<=column; j++){
                        answer[i][j] = arr[i][j];
                    }
                }else{
                    for(int j=0; j<=column; j++){
                        answer[i][j] = 0;
                    }
                }    
            }
            return answer;
        }
    }
}