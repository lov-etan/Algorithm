import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        for(int i=1; i<=N; i++) {
            String pocketmon = br.readLine();
            String numb = Integer.toString(i);
            map.put(numb, pocketmon);
            map2.put(pocketmon, numb);
        }

        for(int k=1; k<=M; k++) {
            String input = br.readLine();
            if(map.containsKey(input)) {
                System.out.println(map.get(input));
            } else {
                System.out.println(map2.get(input));
            }
        }
    }
}
