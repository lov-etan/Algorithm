import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 지금까지 체육복을 갖고 있는 학생들 
        int cnt = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 학생들 체육복 체크 배열 (갖고있음-true / 안 갖고있음-false)
        boolean[] students = new boolean[n+1];
        for(int s = 1; s<=n; s++){
            students[s] = true;
            for(int l=0; l<lost.length; l++){
                if(s == lost[l]){
                    students[s] = false;
                }
            }
        }
        
        //내가 여분의 옷이 있는데 lost에 들었어. 내거 먼저 구하고 생각하자
        for(int i=0; i<reserve.length; i++){
            int giver = reserve[i];
            for(int j=0; j<lost.length; j++){
                int taker = lost[j];
                if(giver == taker && !students[taker]){ 
                    cnt++;
                    students[taker] = true;
                    //더이상 lost, reserve에 포함되지 않게 무의미한 값으로 바꾼다
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        
        // 체육복 분배 시작 
        for(int i=0; i<reserve.length; i++){
            int giver = reserve[i]; //여분의 체육복을 줄 사람의 번호 
            //System.out.println("giver" + giver);
            
            for(int j=0; j<lost.length; j++){
                int taker = lost[j]; //여분의 체육복을 받을 사람의 번호 
                //System.out.println("taker" + taker);
                
                //2. 내 이전 번호가 lost라면?
                if(giver!=1 && giver-1 == taker && !students[taker]){
                    cnt++;
                    students[taker] = true;
                    break;
                }
                //3. 내 이후 번호가 lost라면?
                if(giver!=n && giver+1 == taker && !students[taker]){
                    cnt++; 
                    students[taker] = true;
                    break;
                }
            }
        }
        
        return cnt;
    }
}