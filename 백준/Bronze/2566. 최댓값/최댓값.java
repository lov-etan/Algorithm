import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];

        int max = Integer.MIN_VALUE;
        int maxR = 0;
        int maxC = 0;
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                int num = sc.nextInt();
                arr[r][c] = num;

                max = Math.max(max,num);
                if(num == max){
                    maxR = r;
                    maxC = c;
                }
            }
        }

        maxR = maxR+1;
        maxC = maxC+1;

        System.out.println(max);
        System.out.println(maxR + " " + maxC); //" " + maxC+1 이렇게 하면 문자열 더해지는 것처럼 자동으로 처리됨  그래서 자꾸 6+"1" = 61이 나왔음..




    }
}