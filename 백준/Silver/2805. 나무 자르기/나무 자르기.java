import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        // 이분탐색 - 절단기 높이의 범위(0~나무의 최대 높이)를 설정하여 이 범위 안에서 이분탐색
        int left = 0;
        int right = trees[N-1]+1;
        int answer = 0;

        while(left < right){ //*** 공유기설치 문제와 비교해서 궁금한 점 (근사치도 가능할 때와 정확한 값을 원할 때의 범위 설정이 달라도 되는 것인가?
            int mid = (left + right)/2;
            long sum = cutting(mid); //mid 길이를 절단기의 높이로 가져가서 있는 나무들을 잘라보자. 얼마만큼의 길이가 모아지는가??
                                        //M이 int형의 최댓값을 건들인다. 위험! long으로 튀자
            if(sum >= M) { //원하는 길이보다 더 잘랐어 -> 기준을 올려야 해
                answer = mid;
                left = mid + 1;
            } else { //원하는 길이보다 덜 잘랐어? -> 기준을 내려야 해
                right = mid;
            }
        }

        System.out.println(answer);
    }

    private static long cutting(int mid) {
        long sum = 0;
        for(int treeheight : trees){
            if(treeheight > mid){
                sum += (treeheight - mid);
            }
        }

        return sum;
    }


}