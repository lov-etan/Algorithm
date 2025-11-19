class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int h=2; h<=2000000; h++) {
            int w = (brown+4)/2 - h;
            if((h-2) * (w-2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        return answer;
    }
}