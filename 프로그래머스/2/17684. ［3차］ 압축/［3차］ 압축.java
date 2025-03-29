import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        //hashmap?
        char charA = 'A';
        for(int i=1; i<=26; i++) {
            map.put(String.valueOf(charA), i); // key(글자) -> value(인덱스 ) 그럼 get(글자) -> key가 나옴 
            charA++; //char로 문자 아스키코드 활용 
        }
        int nextIdx = 27;
        
        //앞에서부터 순회하면서 사전에 있는 문자열 중 가장 긴 것을 고른다. 투 포인터? 
        int i=0;
        while( i < msg.length()) { // 하나 전 끝까지 (왜? 다음거 봐야 하니까)
            String w = String.valueOf(msg.charAt(i));
            int j = i+1; 
            
            // 그 다음 숫자들까지 검사해서 혹시 저장된 것이 있는지 확인한다. 
            while(j <= msg.length() && map.containsKey(msg.substring(i,j))) {
                j++;  // 다음것도 포함되었다면 
            }
            
            int currV = map.get(msg.substring(i,j-1));
            System.out.println(currV);
            list.add(currV); //그 전의 값 인덱스 출력하기 
            if(j<=msg.length()) {
                map.put(msg.substring(i,j), nextIdx++);
            }
                    
                
            i += msg.substring(i,j-1).length(); //map에 있던 애들만큼 건너뜀! 
        
        
        }
        
        int[] answer = new int[list.size()];
        System.out.println(list);
        
        for(int z=0; z<list.size(); z++) {
            answer[z] = list.get(z);
        }
        
        return answer;
    }
    }
