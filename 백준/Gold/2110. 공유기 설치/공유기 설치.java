import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] houses;

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int N = sc.nextInt(); //N개의 집
        int C = sc.nextInt(); //C개의 공유기

        houses = new int[N];

        for(int i=0; i<N; i++){
            houses[i] = sc.nextInt();
        }

        Arrays.sort(houses); //거리순으로 집 정렬 // 1 2 4 8 9

        //최소거리의!!!! 최소값, 최대값 정하기
        int min = 1; //최소값은 아무래도 1
        int max = houses[N-1] - houses[0] + 1;

        while(min<max){
            int mid = (min+max)/2; //최소 거리의 중간값
            if(canInstall(mid) < C) { //만약 설치 가능했던 기기의 수가 C보다 작았다? -> 길이 더 줄여야지
                max = mid; //mid보다 짧은 쪽에서 탐색해야 함
            } else { //만약 설치 가능했던 기기의 수가 C보다 많았다? 길이 더 늘려도 돼
                min = mid + 1;
            }

        }

        System.out.println(min - 1); //최소거리의 최소값 (mid보다 1 크게 설정했어서 mid가 정답일 때 웅웅)




    }

    static int canInstall(int distance){
        //반환 값은 설치가능한 공유기의 개수
        int cnt = 1;
        int lastInstall = houses[0]; // 첫번째 집에서 무조건 설치

        for(int i=1; i<houses.length; i++){
            if(houses[i]-lastInstall >= distance){
                cnt++;
                lastInstall = houses[i];
            }
        }

        return cnt;
    }
}