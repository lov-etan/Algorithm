import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 1과의 차이점은 N, A 크기가 엄청 크다는 것이다.
    // DP로 풀어야 함. O(N^2)
    // DP로 풀었으나 - 시간 초과 (더 dp로 하려면 어떻게 해야 하지.?) - 배열 순회가 두 번 반복되는게 문제인 것 같다
    // 이분탐색으로 풀어야 한다. O(N logN)

    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; //[10 20 10 30 20 50]
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //하나씩 검사하며 LIS(가장 긴 부분수열)을 갱신, 추가 해보자
        //원리: 가장 폭이 작은 값들이 증가하면서 부분순열을 이루면 그것이 가장 긴 부분순열이 될 것이다.
        List<Integer> LIS = new ArrayList<>(); //List<> , ArrayList<> 둘 중 고민했음 - 더 유연한 구현체를 선택하는 것이 바람직함

        LIS.add(A[0]); //일단 하나 담고 시작

        for(int i=1;i<N;i++){ //그 다음부터 검사
            if(LIS.get(LIS.size()-1) < A[i]) { // LIS 중 가장 큰 값 < 지금 검사하는 값 (가장 마지막 값으로 순순히 들어가면 됨)
                LIS.add(A[i]);
            } else { //더 작다면 폭이 더 작은 애로 값을 바꿔줄 필요가 있음
                int left = 0; // 가장 첫 인덱스 값
                int right = LIS.size()-1; // 가장 끝 인덱스 값
                while(left<right){
                    int mid = (left+right)/2; //중간 idx 추출
                    if(LIS.get(mid) < A[i]){
                        left = mid+1; //제일 왼쪽 구역 위치를 mid+1로 옮겨준다
                    } else {
                        right = mid;
                    }
                }
                LIS.set(right, A[i]); //right 자리에 A[i]를 넣어준다.

            }
        }

        System.out.println(LIS.size());



    }
}