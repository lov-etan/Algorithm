import java.util.*;

class Solution {
    int[] times;
    
    public long solution(int n, int[] times) {
        this.times = times;
        long answer = 0; // 입국심사를 기다리는 사람 1명 이상 1,000,000,000명 이하 
        
        Arrays.sort(times);
        long min = 0;
        long max = (long) times[times.length - 1] * n + 1; //가장 오래 걸리는 심사대에 n명이 모두 받았을 경우
        
        while(min < max){
            long mid = (min+max)/2; //mid 타임 기준으로 모든 사람이 심사 받는데 걸리는 시간 재보기
            
            //시간에 맞춰 사람들 줄을 서게 해보자 
            System.out.println(mid + " " + lineup(mid));
            if(lineup(mid) < n){ //근데 사람들이 다 못 서면?-> 시간을 늘려
                min = mid+1;
            } else {
                answer = mid; //n 충족 -> 그러나 더 적은 시간으로 심사를 다 받을 수 있는 경우도 봐야지
                              //(범위 줄여주는 쪽으로 answer 배치)
                System.out.println("answer " + answer + " " + lineup(mid));
                max = mid;
            }
        }
        
        
        return answer;
    }
    
    public long lineup(long mid){
        long total = 0; //총 설 수 있는 사람 수 
        
        for(int i=0; i<times.length; i++){
            total += mid / times[i];
        }
        
        return total;
    }
}