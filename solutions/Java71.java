// 71. 개인정보 수집 유효기간

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        String[] todayPd = today.split("[.]");
        
        int todayDate = (Integer.parseInt(todayPd[0])*28*12)+
            (Integer.parseInt(todayPd[1])*28)+Integer.parseInt(todayPd[2]);
        
        for(int i=0; i<terms.length; i++)
        {
            String[] tm = terms[i].split(" ");
            map.put(tm[0], Integer.parseInt(tm[1]));
        }


        for (int i=0; i<privacies.length; i++) {
            String[] pr = privacies[i].split(" ");
            String term = pr[1];
             String[] prDate = pr[0].split("[.]");
            
            int endDate = (Integer.parseInt(prDate[0])*12*28) 
                + (Integer.parseInt(prDate[1])*28) + 
                (Integer.parseInt(prDate[2])) + (map.get(term)*28);
            

            
            if(todayDate >= endDate)
            {
                answer.add(i+1);
            }

        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}