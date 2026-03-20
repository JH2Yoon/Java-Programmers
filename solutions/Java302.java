//302. 매칭 점수

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String word, String[] pages) {

        int n = pages.length;
        word = word.toLowerCase();

        Map<String, Integer> urlIndex = new HashMap<>();
        double[] baseScore = new double[n];
        double[] linkScore = new double[n];
        List<List<String>> links = new ArrayList<>();

        Pattern urlPattern = Pattern.compile(
                "<meta property=\"og:url\" content=\"https://(.*?)\"/>"
        );
        Pattern linkPattern = Pattern.compile(
                "<a href=\"https://(.*?)\">"
        );

        for (int i = 0; i < n; i++) {
            String page = pages[i];

            Matcher urlMatcher = urlPattern.matcher(page);
            urlMatcher.find();
            String url = urlMatcher.group(1);
            urlIndex.put(url, i);

            String lower = page.toLowerCase();
            String[] tokens = lower.split("[^a-z]");

            int count = 0;
            for (String t : tokens) {
                if (t.equals(word)) count++;
            }
            baseScore[i] = count;

            Matcher linkMatcher = linkPattern.matcher(page);
            List<String> list = new ArrayList<>();

            while (linkMatcher.find()) {
                list.add(linkMatcher.group(1));
            }

            links.add(list);
        }

        for (int i = 0; i < n; i++) {

            List<String> outLinks = links.get(i);
            int size = outLinks.size();

            if (size == 0) continue;

            double share = baseScore[i] / size;

            for (String link : outLinks) {
                if (urlIndex.containsKey(link)) {
                    int idx = urlIndex.get(link);
                    linkScore[idx] += share;
                }
            }
        }

        double max = -1;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            double total = baseScore[i] + linkScore[i];

            if (total > max) {
                max = total;
                answer = i;
            }
        }

        return answer;
    }
}