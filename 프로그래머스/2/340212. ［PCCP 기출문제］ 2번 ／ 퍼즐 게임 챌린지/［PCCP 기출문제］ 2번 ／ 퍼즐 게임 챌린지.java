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
        int answer = 0;
        n = diffs.length;
        
        //right 범위 설정을 위해 diff 중 최대로 나올 수 있는 수 구하기
        int maxDiff = 0;
        for(int i=0; i<n; i++){
            maxDiff = Math.max(diffs[i], maxDiff);
        }
        
        //level의 범위
        int left = 1; //양의 정수
        int right = maxDiff + 1;
        
        //이분 탐색
        while(left < right){
            int level = (left+right)/2; //mid = Level
            long time = play(level); 
            
            if(time <= limit) {
                right = level; //시간이 남아나(limit까지 여유가 있어) -> Level 더 줄여봐 
                answer = level; //limit이랑 같아? -> 더 줄여봐(우린 최소 Level을 원해)
            } else {
                left = level+1; //시간 초과 -> Level 키우자 
            }
        }
        
        return answer;
    }
    
    
    public long play(int level){
        long sum = 0;
        
        for(int i=0; i<n; i++){
            if(diffs[i]<=level){
                sum += times[i];
            } else {
                sum += (diffs[i] - level)*(times[i]+times[i-1]) + times[i];
            }
        }
        
        return sum;
    }
}