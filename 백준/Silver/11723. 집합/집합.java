import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if(type.equals("add")) {
                int numb = Integer.parseInt(st.nextToken());
                set.add(numb);
            } else if (type.equals("remove")) {
                int numb = Integer.parseInt(st.nextToken());
                set.remove(numb);
            } else if (type.equals("check")) {
                int numb = Integer.parseInt(st.nextToken());
                if (set.contains(numb)) {
                    sb.append("1\n");
                    //System.out.println(1);
                    //System.out.println(set);
                } else {
                    //System.out.println(0);
                    //System.out.println(set);
                    sb.append("0\n");
                }
            } else if (type.equals("toggle")) {
                int numb = Integer.parseInt(st.nextToken());
                if(set.contains(numb)) {
                    set.remove(numb);
                } else {
                    set.add(numb);
                }
            } else if (type.equals("all")) {
                Collections.addAll(set,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
            } else if (type.equals("empty")) {
                set.clear();
            }
        }

        System.out.println(sb);

    }
}
