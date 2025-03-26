import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int p, int q) {
        if(q == 0) return p;
        return gcd(q, p%q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //M과 N의 최소공배수 구하기 -> 이게 마지막 해가 됨
            int lcm = M * N / gcd(M,N);
            int realY = (y==N) ? 0 : y;

            int answer = -1;

            for(int year = x; year <= lcm; year += M) {
                if( year % N == realY ) {
                    answer = year;
                    break;
                }
            }

            System.out.println(answer);


        }

    }
}
