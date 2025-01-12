import java.util.*;
class Solution {
    public int solution(String name) {
        int alphabet = 0;
        int move = name.length()-1; //좌우 이동 기본값: 처음부터 쭉 가는 것 
        
        for(int i=0; i<name.length(); i++){
            // 1. 알파벳 조작 순서 cnt
            alphabet += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            
            // 2. 위치 선택 (좌우) 
            if(i<name.length()-1 && name.charAt(i+1)=='A') { //중간에 A가 나온다면, 돌아가는게 더 빠를 수도 있다. 
                
                //A의 끝 위치
                int endA = i+1; //일단 확인된 시작점
                while(endA < name.length() && name.charAt(endA)=='A'){
                    endA++;
                }
                
                //move는 첫 번째 글자에 깜빡깜빡 커서가 되어 있다. 
                //(1) 정방향으로 갔다가 돌아 나와서 뒤에서부터 endA까지 닿을지, endAAAApoiu
                //vs (2) 첫 위치에서 <- 로 간 후 역방향으로 돌다가 다시 나와서 앞에서부터 A 시작 전까지 닿을지 endAAAAp
                move = Math.min(move, i*2 + (name.length() - endA));
                move = Math.min(move, (name.length()-endA)*2 + i);
                
                
            }
        }
        
        
        
        return alphabet + move;
    }
}