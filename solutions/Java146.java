// 146. 베스트앨범

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int[] answer = {};
        
        HashMap<String, Integer> genresAlbum = new HashMap<>();
        
        for (int i=0; i<genres.length; i++)
        {
            if (genresAlbum.containsKey(genres[i]))
            {
                genresAlbum.put(genres[i], genresAlbum.get(genres[i]) + plays[i]);
            }
            else
            {
                genresAlbum.put(genres[i], plays[i]);
            }
            
        }
        
        List<String> genresList = new ArrayList<>(genresAlbum.keySet());
        Collections.sort(genresList, (o1, o2) -> (genresAlbum.get(o2).compareTo(genresAlbum.get(o1))));
        
        List<Integer> answerList = new ArrayList<>();
        genresList.forEach(li -> {
            HashMap<Integer, Integer> playsMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (li.equals(genres[i])) {
                    playsMap.put(i, plays[i]);
                }
            }

            List<Integer> playsList = new ArrayList<>(playsMap.keySet());
            Collections.sort(playsList, (o1, o2) -> (playsMap.get(o2).compareTo(playsMap.get(o1))));

            answerList.add(playsList.get(0));
            if (playsList.size() != 1) {
                answerList.add(playsList.get(1));
            }
        });
        answer = new int[answerList.size()];

        for (int idx = 0; idx < answerList.size(); idx++) {
            answer[idx] = answerList.get(idx);
        }
        
        

        return answer;
    }
}