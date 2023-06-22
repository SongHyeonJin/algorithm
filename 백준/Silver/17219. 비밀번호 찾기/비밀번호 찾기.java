import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int saveSite = Integer.parseInt(st.nextToken());
        int findPwdSite = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i=0; i<saveSite; i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            map.put(site, pwd);
        }
        for(int i=0; i<findPwdSite; i++){
            String site = br.readLine();
            sb.append(map.get(site)).append("\n");
        }
        System.out.println(sb);
    }
}