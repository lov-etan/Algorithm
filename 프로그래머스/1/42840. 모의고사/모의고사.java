import java.util.*;

class Solution {
    int[] first = {1, 2, 3, 4, 5}; //5
    int[] second = {2,1,2,3,2,4,2,5}; //8
    int[] third = {3,3,1,1,2,2,4,4,5,5}; //10
    int[] scores = new int[3];
    
    public int[] solution(int[] answers) {
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        //점수 계산 
        for(int i=0; i<answers.length; i++){
            if(first[(i%5)] == answers[i]) scores[0]++;
            if(second[(i%8)] == answers[i]) scores[1]++;
            if(third[(i%10)] == answers[i]) scores[2]++;
        }
        
        //가장 많이 맞힌 개수는?
        max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        //가장 많이 맞힌 사람 나와!
        for(int j=0; j<3; j++){
            if(max==scores[j]) list.add(j+1);
        }
        
        int[] answer = new int[list.size()];
        for(int k=0; k<list.size(); k++) {
            answer[k] = list.get(k);
        }
        
        
        return answer;
    }
}