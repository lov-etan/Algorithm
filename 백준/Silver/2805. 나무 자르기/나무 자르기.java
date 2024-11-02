import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //나무의 수
        M = sc.nextInt(); //상근이가 집으로 가져가려고 하는 나무의 길이

        trees = new int[N];

        for(int i=0; i<N; i++){
            trees[i] = sc.nextInt();
        }

        Arrays.sort(trees);
        //System.out.println(Arrays.toString(trees));


        //이분탐색 //mid = 절단기 높이
        int left = 0; //**필요한 길이가 M이면 절단기의 높이가 M이어도 됨
        int right = trees[N-1];
        int answer = 0;

        //System.out.println(left + " " + right);


        while(left<right){
            int mid = (left+right)/2;
            //System.out.println("left" + left + " " + "right" + right +  " " + "mid" + mid);
            //System.out.println(cutting(mid));

            long sum = cutting(mid);

            if(sum >= M){ //자른 후의 결과가 M보다 크다면 -> 기준을 올려야 함
                answer = mid;
                left = mid+1;
            } else {
                right = mid;
            }
//            } else if(sum == M){ //** 나무를 항상 딱 맞게 가져갈 순 없다.
//                answer = mid;
//                break;
//            }


            //내가 원하는 양을 얻을 수 없는 조건일 때, 무한 루프가 생긴다.
            //나무 높이가 다 10인데 우리는 11을 원해 - 11을 딱 맞춰는 불가능 - 그럼 6+6 12라도 가져가야 해

        }
        System.out.println(answer);

    }

    static long cutting(int cPoint){ //**나무의 길이 M이 2,000,000,000까지 가능하므로 이 값이 int형(2,147,483,647)을 넘길 가능성이 있다.
        long sum = 0;
        for(int i=0; i<N; i++){
            if(trees[i] > cPoint){
                sum += trees[i] - cPoint;
            }
        }

        return sum;
    }
}