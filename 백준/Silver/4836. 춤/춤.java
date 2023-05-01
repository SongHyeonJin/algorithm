import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line= br.readLine()) != null){
            sb.setLength(0);
            List<String> list = Arrays.asList(line.split(" "));

            List<String> errorList = new ArrayList<>();

            // 규칙 1
            for(int i=0; i<list.size(); i++){
                if(list.get(i).equals("dip")){
                    if( !(i >= 2 && list.get(i-2).equals("jiggle"))
                    && !(i >= 1 && list.get(i-1).equals("jiggle"))
                    && !(i+1 <= list.size()-1 &&  list.get(i+1).equals("twirl"))){
                        list.set(i, "DIP"); // 1번 규칙 어긋난 dip는 대문자 출력
                        errorList.add("1");
                        break;
                    }
                }
            }

            // 규칙 2
            if(list.size() < 3){
                errorList.add("2");
            }
            else if(!list.get(list.size()-3).equals("clap")
            || !list.get(list.size()-2).equals("stomp")
            || !list.get(list.size()-1).equals("clap")){
                errorList.add("2");
            }

            // 규칙 3
            if(list.contains("twirl") && !list.contains("hop")){
                errorList.add("3");
            }

            // 규칙 4
            if(list.get(0).equals("jiggle")){
                errorList.add("4");
            }

            // 규칙 5
            if(!list.contains("dip") && !list.contains("DIP")){
                errorList.add("5");
            }

            switch (errorList.size()){
                case 0:
                    sb.append("form ok: ");
                    break;
                case 1:
                    sb.append("form error ").append(errorList.get(0)+": ");
                    break;
                default:
                    sb.append("form errors ");
                    for(int i=0; i<errorList.size(); i++){
                        if(i == 0)
                            sb.append(errorList.get(i));
                        if(i > 0 && i< errorList.size()-1)
                            sb.append(", "+ errorList.get(i));
                        if(i == errorList.size()-1)
                            sb.append(" and ").append(errorList.get(i)+": ");
                    }
                    break;
            }
            for(String dance : list){
                sb.append(dance).append(" ");
            }
            System.out.println(sb);
        }
    }
}