package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence;
        while((sentence=br.readLine())!=null){
            System.out.println(check(sentence));
        }
    }
    static String check(String sentence){
        // 규칙 1, 2, 3, 4, 5
        boolean[] checkBol = new boolean[5];
        for(int i=0;i<5;i++) checkBol[i] = true;
        String[] dance = sentence.split(" ");
        int count = 0;
        int dip = 0;
        int twirl = 0;
        int hop = 0;
        for(int i=0;i<dance.length;i++){
            if(dance[i].equals("twirl")) twirl++;
            if(dance[i].equals("hop")) hop++;
            if(dance[i].equals("dip")) dip++;
            if(dance[i].equals("dip")){
                boolean dcheck = false;
                if(i==1){
                    if(dance[i-1].equals("jiggle")) dcheck = true;
                }
                if(i>=2){
                    if(dance[i-1].equals("jiggle") || dance[i-2].equals("jiggle")) dcheck = true;
                }
                if(i<=dance.length-2){
                    if(dance[i+1].equals("twirl")) dcheck = true;
                }
                if(!dcheck){
                    count++;
                    dance[i] = dance[i].toUpperCase();
                }
            }
            // 규칙 4 어길 시
            if(i==0) if(dance[i].equals("jiggle")) checkBol[3] = false;
        }
        if(count>0) checkBol[0] = false;
        // 규칙 2 어길 시
        if(dance.length<3
            || !(dance[dance.length-3]+dance[dance.length-2]+dance[dance.length-1]).equals("clapstompclap")) checkBol[1] = false;
        // 규칙 5 어길 시
        if(dip==0) checkBol[4] = false;
        // 규칙 3 어길 시
        if(twirl>0 && hop==0) checkBol[2] = false;
        String answer = "";
        int cnt = 0;
        for(int i=0;i<5;i++){
            if(!checkBol[i]){
                answer += (i+1);
                cnt++;
            }
        }
        String result = "form ";
        if(cnt == 0){
            result += "ok";
        } else if (cnt == 1) {
            result += "error ";
        }else{
            result += "errors ";
        }
        String[] word = answer.split("");
        for(int i=0;i<word.length;i++){
            if(i==0){
                result+=word[i];
            }else if(i==cnt-1){
                result = result+" and "+word[i];
            }else{
                result = result+", "+word[i];
            }
        }
        result+=": ";
        for(int i=0;i<dance.length;i++){
            result+=dance[i]+" ";
        }
        return result;
    }
}
