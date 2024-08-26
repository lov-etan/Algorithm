import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15]; //char의 초기값은 null(이는 0과 다르다)

        for(int r=0;r<5;r++){
            String inputString = br.readLine();
            for(int c=0;c<inputString.length();c++){
                arr[r][c] = inputString.charAt(c);
            }
        }
        //System.out.println(Arrays.deepToString(arr));

        StringBuilder resultStr = new StringBuilder();

        for(int c=0;c<15;c++){
            for(int r=0;r<5;r++){
                if(arr[r][c]!=(char)0){ //null 값은 (char)0 으로 나타낼 수 있다.
                    resultStr.append(arr[r][c]);
                }
            }
        }

        System.out.println(resultStr);


    }
}