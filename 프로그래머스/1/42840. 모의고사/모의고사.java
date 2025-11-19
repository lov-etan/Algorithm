import java.util.*;
class Solution {
    int one[] = {1,2,3,4,5};
    int two[] = {2,1,2,3,2,4,2,5};
    int three[] = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answer;
        
        int maxScore = 0;
        int[] scores = new int[4];
        int idx1 = 0; int idx2 = 0; int idx3 = 0;
        for(int i=0; i<answers.length; i++) {
            int ans = answers[i];
            if(ans == one[idx1]) scores[1]++;
            if(ans == two[idx2]) scores[2]++;
            if(ans == three[idx3]) scores[3]++;
            maxScore = Math.max(scores[1], Math.max(scores[2], scores[3]));
            
            idx1 = (idx1+1)%5;
            idx2 = (idx2+1)%8;
            idx3 = (idx3+1)%10;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=3; i++) {
            if(scores[i] == maxScore) arr.add(i);
        }
        
        answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}