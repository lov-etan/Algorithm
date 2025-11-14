import java.util.*;

class Solution {
    static int[] numbers;
    static int answer, target;
    static void dfs(int idx, int num) {
        if(idx == numbers.length) {
            if(num == target) answer++;
            return;
        }
        
        dfs(idx+1, num - numbers[idx]);
        dfs(idx+1, num + numbers[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        
        return answer;
    }
}