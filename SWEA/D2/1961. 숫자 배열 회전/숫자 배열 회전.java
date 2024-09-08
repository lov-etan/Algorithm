import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    //출력 결과가 90의 첫 열 " "  180의 첫 열 " " 270의 첫 열 ... 이런 식으로 인출된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine()); //3
            String[][] map = new String[N][N];
            String[][] rot90 = new String[N][N];
            String[][] rot180 = new String[N][N];
            String[][] rot270 = new String[N][N];

            //배열 다 받아오기
            for(int r=0; r<N;r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N;c++){
                    map[r][c] = st.nextToken();
                }
            }
            //System.out.println(Arrays.deepToString(map));

            //회전 시 각자의 위치 찾아주기
            //세로 방향으로 가는 애들
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){ //r,c 정방향 순회하면서 숫자 채우는거 힘들었다....
                    rot90[c][N-1-r] = map[r][c];
                    rot180[N-(r+1)][N-(c+1)] = map[r][c];
                    rot270[N-1-c][r] = map[r][c];
                }
            }

            //가로 방향으로 가는 애
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){

                }
            }

//            System.out.println(Arrays.deepToString(rot90));
//            System.out.println(Arrays.deepToString(rot180));
//            System.out.println(Arrays.deepToString(rot270));



            StringBuilder sb = new StringBuilder();
            sb.append("#"+tc+"\n");
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    sb.append(rot90[r][c]);
                }
                sb.append(" ");
                for(int c=0; c<N; c++){
                    sb.append(rot180[r][c]);
                }
                sb.append(" ");
                for(int c=0; c<N; c++){
                    sb.append(rot270[r][c]);
                }
                sb.append("\n");
            }

            System.out.print(sb);


        }
    }


}