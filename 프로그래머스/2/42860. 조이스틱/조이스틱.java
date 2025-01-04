import java.util.*;
class Solution {
    public int solution(String name) {
        int alphabet = 0; //위 아래 이동 수
        int move = name.length()-1; // 좌 우 이동 수 
        
        for(int i=0; i<name.length(); i++){
            // 1. 알파벳 선택(순서대로, 역순대로)
            alphabet += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            
            // 2. 위치 선택( < or > ?) - 기본값: 그냥 순서대로 가는 것
            //중간에 A가 있다면 선택의 기로에 놓이게 됨
            if(i<name.length()-1 && name.charAt(i+1)=='A') { //만약 중간에 'A'가 등장한다면?
                
                //A는 언제 끝나니?
                int endA = i+1;
                while(endA < name.length() && name.charAt(endA)=='A') {
                    endA++;
                }
                //왼쪽에서 쭉 가던거 돌아가서 뒤에 endA 이후 것만 취하기 vs 뒤에서부터 갔다가 앞에서 돌기 
                move = Math.min(move, i*2 + (name.length() - endA));
                move = Math.min(move, (name.length() - endA)*2 + i);
                
            } 
        }
        return alphabet+move;
    }
}