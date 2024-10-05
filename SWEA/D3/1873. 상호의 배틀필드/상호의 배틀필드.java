import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int H,W, posR, posC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] Dir = {'^','v','<','>'};

    static char[][] map;
    static int[] pos;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); //높이(행)
            W = Integer.parseInt(st.nextToken()); //너비(열)

            map = new char[H][W];
            //현재 전차의 위치
            posR = 0;
            posC = 0;


            for(int r=0; r<H; r++){
                String str = br.readLine();
                for(int c=0; c<W; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == Dir[0] || map[r][c] == Dir[1] || map[r][c] == Dir[2] || map[r][c] == Dir[3]) {
                        posR = r;
                        posC = c;

                    }
                }
            }

            //사용자가 입력을 넣어 전차를 이동시킴
            int N = Integer.parseInt(br.readLine());
            String inputs = br.readLine();
            for(int i=0; i<N; i++){
                char input = inputs.charAt(i);
                play(numbering(input));
            }

            //System.out.println(Arrays.deepToString(map));

            //map 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for(int r=0; r<H; r++){
                for(int c=0; c<W; c++) {
                    sb.append(map[r][c]);
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }

    static void play(int input){ // 0-상 1-하 2-좌 3-우
        if(input != 10){ //U D L R 일 때,
            map[posR][posC] = Dir[input]; //전차 방향을 ^으로 바꾸고
            //만약 그 방향으로 한 칸 더 갔을 때
            //범위 내에 있고, map[nr][nc]='.' 평지면 이동한다.
            int nr = posR + dr[input];
            int nc = posC + dc[input];

            if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]=='.'){
                map[nr][nc] = Dir[input]; //이동한 곳으로 전차 옮겨주기(해당 모양으로)
                map[posR][posC] = '.'; //이동 전 부분 map . 으로 바꾸기
                posR = nr;
                posC = nc; //그쪽으로 이동
            }

        } else { //만약 Shoot이 걸리면?
            //System.out.println(map[posR][posC]);
            //현재 전차 모양 확인해서 해당 방향으로 포탄 쏘기
            int dir = numbering(map[posR][posC]); //현재 전차 모양의 번호 추출
            int bombR = posR + dr[dir];
            int bombC = posC + dc[dir]; //포탄의 현재 위치
            //해당 방향으로 포탄이 범위를 벗어나지 않을 때까지 돌리기
            while(bombR>=0 && bombR<H && bombC>=0 && bombC<W){
                //벽돌 벽(*)에 마주치면 (.)으로 바뀜
                if(map[bombR][bombC] == '*'){
                    map[bombR][bombC] = '.';
                    break;
                } else if(map[bombR][bombC] == '#') {//강철 벽(#)에 마주치면 stop
                    break;
                }

                //아무것도 안 걸리고 여기까지 내려왔으면 다시 한 칸 이동
                bombR += dr[dir];
                bombC += dc[dir]; //포탄의 현재 위치

            }

        }


    }

    static int numbering(char input){
        if(input == 'U' || input == '^'){
            return 0;
        } else if(input == 'D' || input == 'v'){
            return 1;
        } else if(input == 'L' || input == '<'){
            return 2;
        } else if(input == 'R' || input == '>'){
            return 3;
        }
        return 10; //만약 input에 Shoot!이 들어오면, 10을 반환
    }

}