class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = -1; int h = -1;
        for(int i=0; i<sizes.length; i++) {
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            
            w = Math.max(w,a);
            h = Math.max(h,b);
        }
        answer = w*h;
        return answer;
    }
}