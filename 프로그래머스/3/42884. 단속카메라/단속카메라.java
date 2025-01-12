import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        // 시작 지점 기준으로 sort 
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(routes));
        
        //현재 가장 끝 지점을 저장한다. 
        int end = routes[0][1];
        //1) new 시작 지점 <= 끝 지점 : cnt 변화 없음
        //2) new 시작 지점 > 끝 지점 : cnt 변화 + 끝 지점 이동 
        for(int i=1; i<routes.length; i++){
            if(routes[i][0] > end){
                answer++;
                end = routes[i][1];
            }
        }
    
        
        return answer;
    }
}