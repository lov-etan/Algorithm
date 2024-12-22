import java.util.*;

public class Music {
    int idx; //고유번호
    int play; //재생 수
    
    public Music(int idx, int play){
        this.idx = idx;
        this.play = play;
    }
    
    public int getIdx(){
        return idx;
    }
    
    public int getPlay(){
        return play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        //1. 장르(총 재생 수, 내림차순)       
        // 1-1. map {장르 - 총 재생 수}
        HashMap<String, Integer> map = new HashMap<>(); 
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        // 1-2. List 정렬 - 총 재생수-내림차순
        ArrayList<String> sortedGenres = new ArrayList<>();
        for(String genre : map.keySet()) {
            sortedGenres.add(genre);
        }
        sortedGenres.sort((o1,o2)-> map.get(o2)-map.get(o1));  //재생수 내림차순 
        
        
        //2. 장르 내 노래 (재생수-내림차순/ 고유번호-오름차순)
        for(String genre: sortedGenres) {
            //한 장르 내에서 음악 순위 볼 것임
            ArrayList<Music> musics = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genre.equals(genres[i])) {
                    musics.add(new Music(i, plays[i])); //내 장르다? 고유번호(idx), 재생수(play) list에 넣어주기
                }
            }
            
            musics.sort(Comparator.comparing(Music::getPlay).reversed().thenComparing(Music::getIdx)); //정렬
            
            answer.add(musics.get(0).idx); //1등 노래의 고유번호 넣어주기
            if(musics.size() != 1){
                answer.add(musics.get(1).idx); //2등 노래 고유번호 넣어주기  
            }
            
        }//장르for

        return answer.stream().mapToInt(i->i).toArray();
    }
}