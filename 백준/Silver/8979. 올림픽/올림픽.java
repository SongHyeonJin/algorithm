import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int [][] arr = new int[n][4];
	    
	    for(int i=0;i<n;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<4;j++){
	            arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    Arrays.sort(arr, new Comparator<int []>(){
	       @Override
	       public int compare(int [] o1,int [] o2){
	           if(o1[1]==o2[1]){
                    if(o1[2]==o2[2]){
                        return o2[3]-o1[3];
                    }
                return o2[2]-o1[2];
	           }
	           return o2[1]-o1[1];
	       }
	    });
	    
		int rank = 1;

	    for(int i=0;i<n;i++){
	        if(i>0){
				if(arr[i][1] != arr[i - 1][1]
                   || arr[i][2] != arr[i - 1][2]
                   || arr[i][3] != arr[i - 1][3]) {
					rank = i + 1;
				}
			}
            
			if(arr[i][0] == k) {
                System.out.println(rank);
                return;
            }
	    }
	}
}