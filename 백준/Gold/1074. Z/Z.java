
import java.io.*;
import java.util.*;

public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        find(N, r, c);
        System.out.println(cnt);

    }

    static void find(int N, int r, int c) {
        //System.out.println(N + " " + r + " " + c );
        if(N==1) {
            cnt += c + r*2;
            return;
        }

        int mid = (int) Math.pow(2,N)/2;

        if(c < mid && r < mid) { //제2사분면
            cnt += 0;
            //System.out.println("2사분면" + cnt);
            find(N-1, r, c);
        } else if(c >= mid && r < mid) { //제1사분면
            cnt += (int) Math.pow(mid,2);
            //System.out.println("1사분면" + cnt);
            find(N-1, r, c-mid);
        } else if(c<mid && r>=mid) { //제3사분면
            cnt += (int) Math.pow(mid,2)*2;
            //System.out.println("3사분면" + cnt);
            find(N-1, r-mid, c);
        } else { //제4사분면
            cnt += (int) Math.pow(mid,2)*3;
            //System.out.println("4사분면" + cnt);
            find(N-1, r-mid, c-mid);
        }
    }
}
