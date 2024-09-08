import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//스택으로 풀어봄
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for(int tc=1; tc<=10; tc++){
            int hundred = Integer.parseInt(br.readLine());

            int[][] map = new int[hundred][hundred];

            for(int r=0; r<hundred; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<hundred; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            //---채워넣기 끝

            int cnt = 0; //교착상태 count

            //세로 방향 순회하며 Stack 이용해서 2번과 1번에 부딫히는 부분 구하기
            for(int c=0; c<hundred; c++){
                Stack<Integer> stack = new Stack<>(); //세로줄에서 체크할 스택
                for(int r=0; r<hundred; r++){
                                        //와.. 문제 잘 보기...  (map상에서 1이 위, 2가 밑이면 교착)
                    if(map[r][c]==1){ //2가 나오면 스택에 쌓아주기
                        stack.push(1);
                    } else if(map[r][c]==2){
                        if(!stack.isEmpty() && stack.peek()==1){
                            stack.clear();
                            cnt++;
                        }
                    }


                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(cnt);
            System.out.println(sb);


        }//tc

//        7
//        2 0 1 0 2 0 2
//        0 1 0 0 0 0 0
//        0 0 2 0 0 2 0
//        0 0 0 0 2 1 1
//        0 0 0 0 0 2 0
//        0 0 1 2 0 1 2
//        0 0 2 1 1 0 1



    }

}