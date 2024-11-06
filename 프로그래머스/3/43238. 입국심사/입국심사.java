import java.util.*;

class Solution {
    int[] times;
    
    public long solution(int n, int[] times) {
        this.times = times;
        long answer = 0; //사람 수가 1억 명 -> long형 반환 
        
        Arrays.sort(times);
        
        //시간
        long min = 0;
        long max = (long) times[times.length - 1] * n + 1; //모든 사람이 가장 오래 걸리는 곳에 줄 섰을 경우
        
        while(min < max){
            long mid = (min + max)/2;
            
            //시간에 맞춰 사람들 줄 서게 해보자 
            //System.out.println(mid + " "+ lineup(mid));
            if(lineup(mid) < n){ // 근데 사람들이 다 못 서면? -> 더 설 수 있게 시간 늘리기
                min = mid + 1; 
            } else {
                answer = mid; //이쪽으로 옮기니 답이 나온다? - 왜일까?
                max = mid;
            }
            
        }
        return answer;
    }
    
    public long lineup(long time){
        long totalPeople = 0;
        for(int i=0; i<times.length; i++){
            totalPeople += time / times[i]; 
        }
        
        return totalPeople;
    }
}