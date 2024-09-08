import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();

        for(int tc=1 ;tc<=T ;tc++){
            int N = sc.nextInt(); //1번부터 N번까지 N개의 상자
            int Q = sc.nextInt(); //Q회 동안 상자 숫자 변경

            int[] boxes = new int[N+1];

            for(int i=1; i<=Q; i++){
                int L = sc.nextInt();
                int R = sc.nextInt();

                for(int j=L; j<=R; j++){
                    boxes[j] = i; //i를 넣는다는거 잊지 말기!!!!
                }
                //System.out.println(Arrays.toString(boxes));
            }

            System.out.print("#" + tc + " ");
            for(int i=1; i<=N; i++){
                System.out.print(boxes[i]+" ");
            }
            System.out.println();
        }
    }
}