
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();


        // N의 약수 어떻게 구하지?
        for(int i=1; i<=N; i++) {
            for(int j=i; j<=N; j+=i) {
                //System.out.println(i + " " + j);
                if(j==N) {
                    list.add(i);
                }
            }
        }

        //System.out.println(list);
        //System.out.println(k);
        if(list.size() <= k-1) {
            System.out.println(0);
        } else {
            System.out.println(list.get(k-1));
        }

    }

}
