import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            String str = br.readLine();
            int[] claps = new int[str.length()]; //인덱스 = 최소 필요한 clap 수
            int cntClaps = 0; //현재 박수 치고 있는 사람
            int add = 0 ;//추가로 고용해야 할 사람
            for(int min=0; min<str.length(); min++){
                int people = str.charAt(min) - '0'; // 1 1 0 0 1 1
                claps[min] = people;
                //System.out.println(Arrays.toString(claps) + "People: " + people);

                //people이 0일 때는 고려해줄 필요가 없음
                if(people != 0){
                    if(cntClaps >= min){
                        cntClaps += people;
                    } else { // 만약 현재 박수치고있는사람(cntClaps)가 min(필요한 최소 박수 수)보다 작다면(부족하다면)
                        add += min - cntClaps; //최소 필요한 수 - 지금 치는 사람들 = 더 고용할 사람들 (계속 더해갈거니까 +=)
                        //System.out.println("add " + add);
                        cntClaps = min; //고용하면 현재 박수 치고 있는 사람 수 최소 필요한 수로 맞춰짐
                        cntClaps += people; //만약 조건이 맞춰지면 min인덱스에 해당하는 people수만큼 다 박수 치기 시작함
                        //System.out.println("현재 박수 치는 사람:" +  cntClaps);
                    }
                }
            }

            System.out.println("#" + tc +  " " + add);






        }


    }
}