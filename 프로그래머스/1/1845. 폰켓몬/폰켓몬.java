import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int i=0; i<N; i++){
            set.add(nums[i]);
        }
        
        if(N/2 < set.size()){
            answer = N/2;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}