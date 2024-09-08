import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0; //최종 결과 //연속 흰색 K칸인 것들의 수
            //가로 방향으로 순회하면서 k연속의 1 세주기
            for(int r = 0; r < N; r++) {
                int tmp = 0;
                for(int c = 0; c < N; c++) {
                    if(map[r][c] == 1){
                        tmp++;
                    } else if(map[r][c]==0 && tmp >= 1){ //1이 나오다가 바뀌는 지점 체크
                        if(tmp == K){ //조건을 만족한 상태에서 바뀐다면
                            cnt++; //딱 3칸인 것의 개수 올려주기
                            tmp = 0; //저장공간 초기화
                        } else { //조건을 만족하지 않은 경우라면
                            tmp = 0; //그냥 저장공간만 초기화
                        }
                    }
                }
                //미자막은 바뀌는 지점이 없으니까 맨끝에서 tmp == 3이 되었다면 그 경우도 고려해줘야 함
                if(tmp == K) cnt++;
            }


            //세로 방향으로 순회하면서 k연속의 1 세주기
            for(int c= 0; c < N; c++) {
                int tmp = 0;
                for(int r = 0; r < N; r++) {
                    if(map[r][c] == 1){
                        tmp++;
                    } else if(map[r][c]==0 && tmp >= 1){ //1이 나오다가 바뀌는 지점 체크
                        if(tmp == K){ //조건을 만족한 상태에서 바뀐다면
                            cnt++; //딱 3칸인 것의 개수 올려주기
                            tmp = 0; //저장공간 초기화
                        } else { //조건을 만족하지 않은 경우라면
                            tmp = 0; //그냥 저장공간만 초기화
                        }
                    }
                }
                //미자막은 바뀌는 지점이 없으니까 맨끝에서 tmp == 3이 되었다면 그 경우도 고려해줘야 함
                if(tmp == K) cnt++;
            }

            System.out.println("#" + tc + " " + cnt);


        }//tc
    }//main
}