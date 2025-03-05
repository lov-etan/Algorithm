import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> allSet = new HashSet<>();
        Set<String> combSet = new HashSet<>();

        for(int i=0; i<N; i++) {
            String name = br.readLine();
            allSet.add(name);
        }

        for(int i=0; i<M ;i++) {
            String name = br.readLine();
            if(allSet.contains(name)) {
                combSet.add(name);
            } else {
                allSet.add(name);
            }
        }

        List<String> sortedList = new ArrayList<>(combSet);
        Collections.sort(sortedList);

        sb.append(combSet.size() + "\n");
        for( int i=0; i<combSet.size(); i++) {
            sb.append(sortedList.get(i) + "\n");
        }

        System.out.println(sb);
    }
}
