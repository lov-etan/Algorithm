import java.util.*;

class Solution {
    
    class Node{
        String word;
        int cnt;

        Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words)); //우와 이런 것도 있네
        
        boolean[] visited = new boolean[words.length];

        int answer = Integer.MAX_VALUE ; //minCnt

        /////////////////// bfs 시작////////////////////////////
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0)); //hit 넣기

        while(!q.isEmpty()) {
            Node curr = q.poll(); //hit을 빼고
            //curr.cnt++; // 이렇게 하니 틀렸어 
            System.out.println(curr.word);
            
            if(curr.word.equals(target)){
                answer = Math.min(answer, curr.cnt);
                break;
            }
            
            
            for(int k=0; k< words.length; k++){
                if(!visited[k]){
                 String next = words[k];
                int same = 0;
                for(int j=0; j<begin.length(); j++){
                    if( curr.word.charAt(j) == next.charAt(j) ){
                        same++;
                    }
                }
                
                if(same == begin.length()-1){
                    visited[k] = true; 
                    q.add(new Node(next, curr.cnt+1));
                }   
                }
                
            }//
            
            
            // //다음 타깃을 찾는다.
            // for(int k=list.size()-1; k>=0; k--){
            // // list 중 단어 하나 뽑아
            //     int same = 0;
            //     String next = list.get(k);
            //     // 한 글자만 달라야 해 
            //     for(int j=0; j<begin.length(); j++){
            //         if(curr.word.charAt(j) == next.charAt(j)){
            //             same++;
            //         }
            //     }
            //     //만약 한 글자만 다르면 ? - visited[](list에서 빼기) 처리 해주고 큐에 넣어주기 
            //     if(same == begin.length()-1){
            //         list.remove(k); //visited 처리 (다시는 돌아갈 일 없다 - list 안에서 찾는데 이걸 없앴으니까)
            //         q.add(new Node(next, curr.cnt));
            //     }
            // }

        }
        ///////////////////////////////////////////////////////


        if(answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        return answer;
    }
}