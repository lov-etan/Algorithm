import java.util.*;

public class Music {
        int idx; //고유번호 
        int play; //재생시간 
        
        public Music(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
        public int getIdx() {
            return idx;
        }
        
        public int getPlay() {
            return play;
        }
    }

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        //1. 많이 들은 순서에 따라 genre 나열 (장르-시간 연결하고, 재생시간 순서대로 배치) 
            // 장르-총재생수 연결해볼까?
        HashMap<String, Integer> genres_plays = new HashMap<>(); //장르 - 총 재생횟수 연결 
        for(int i=0; i<genres.length; i++){
            genres_plays.put(genres[i], genres_plays.getOrDefault(genres[i], 0)+plays[i]);
        }
        
            // 장르를 총 재생수 내림차순으로 정렬해보자! (많이 들은 장르부터 줄서세요)
        ArrayList<String> final_genres = new ArrayList<>();
        for(String genre: genres_plays.keySet()) {
            final_genres.add(genre);
        }
        final_genres.sort((o1,o2)-> genres_plays.get(o2)-genres_plays.get(o1)); //많이 들은 순으로 genre 배치
        
        
        //2. 장르 내 가장 많이 들은 노래 선별
        for(String genre : final_genres) { //장르 인기 순위순으로 시작
            //이 장르 안에서의 인기순위가 궁금해(이중 2개만 필요)
            ArrayList<Music> musics = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genre.equals(genres[i])) {
                    musics.add(new Music(i,plays[i])); //인기순위 List로 나열 
                }
            }
            
            // 정렬 기준 - 1) 재생 수 내림차순 2) 고유번호 오름차순 
            musics.sort(Comparator.comparing(Music::getPlay).reversed().thenComparing(Music::getIdx));
            
            //정답array에 상위 2개만 넣기
            answer.add(musics.get(0).idx); //고유번호 넣어야 해
            if(musics.size() != 1){
                answer.add(musics.get(1).idx);
            }
        }//장르 for
        
        return answer.stream().mapToInt(i-> i).toArray();
    }
}