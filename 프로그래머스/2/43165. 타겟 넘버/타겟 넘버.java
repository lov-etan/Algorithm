class Solution {
    int[] numbers;
    int N;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        N = numbers.length;
        this.answer = answer;
        dfs(0,0);
        return answer;
        
    }
    
    void dfs(int idx, int sum){
        //기저
        if(idx == N) {
            if(sum == target) {
                answer++;
            }
            
            return;
        }
        
        //재귀
        int tmpSum = sum + numbers[idx];
        dfs(idx+1, tmpSum);
        
        int tmpSum2 = sum - numbers[idx];
        dfs(idx+1, tmpSum2);
    }
    
    
}