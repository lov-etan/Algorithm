import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] sArr = s.toCharArray();
        System.out.println(sArr);
        
        for(int i=0; i<sArr.length; i++) { //총 4번 반복 
            //시작 시점: i
            Stack<Character> stack = new Stack<>(); //0, 1, 2, 3부터 시작할 때 담을 stack
            
            for(int j=0; j<sArr.length; j++) { //new시작부터 끝까지 stack 쌓기 
                int idx = (i+j) % sArr.length; 
                 
                char curr = sArr[idx];
                
                if(stack.isEmpty()) {
                    stack.add(curr); 
                    continue;
                }
                
                if(curr == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if(curr == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if(curr == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.add(curr);
                } 
                
            } 
            
            if(stack.isEmpty()) {
                answer++;
            }
            
            System.out.println(answer);
            
            
        }
        
        
        return answer;
    }
}