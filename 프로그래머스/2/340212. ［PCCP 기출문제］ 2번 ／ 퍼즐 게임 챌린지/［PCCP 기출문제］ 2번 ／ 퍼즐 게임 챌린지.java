import java.util.*;
class Solution {
    int n;
    int[] diffs;
    int[] times;
    long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        n = diffs.length;
        int answer = 0;
        
        
        int maxDiff = 0;
        for(int i=0; i<diffs.length; i++){
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        
        //level 최소, 최대 범위 설정 
        int left = 1;
        int right = maxDiff + 1;
        
        while(left < right){
            int level = (left+right)/2;
            
            long time = game(level);
            if(time <= limit){
                right = level; //시간 널널해? -> level 더 낮춰보자 //limit이랑 같아? level 더 줄여봐
                answer = level; //'최소'값을 구해야 하기 때문에 작은 값으로 가는 것을 선택

            } else {
                left = level+1; //제한 시간 안에 못 들어와? -> level 더 키워야 해

            }
        }

        return answer;
        
        
    }
    
    public long game(int level){
        long sum = 0;
        
        for(int i=0; i<n; i++){
            if(diffs[i] <= level) {
                sum += times[i];
            } else {
                sum += (diffs[i]-level)*(times[i] + times[i-1]) + times[i];
            }
        }
        
        return sum;
    }
}