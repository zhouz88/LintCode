import java.util.*;

class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, String> finalMap = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            String abbr = abbr(dict.get(i));
            map.putIfAbsent(abbr, new ArrayList<>());
            map.get(abbr).add(dict.get(i));
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            if (e.getValue().size() == 1) {
                finalMap.put(e.getValue().get(0), e.getKey());
            } else {
                List<String> res = new ArrayList<>();
                abbrSameWords(e.getValue(), res);
                for (int i = 0; i < e.getValue().size(); i++) {
                    finalMap.put(e.getValue().get(i), res.get(i));
                }
            }
        }
        List<String> rest= new ArrayList<>();
        for (String k : dict) {
            rest.add(finalMap.get(k));
        }
        return rest;
    }

    private void abbrSameWords(List<String> value, List<String> res) {
        String[] visited = new String[value.size()];
        for (int i = 1; i < value.get(0).length(); i++) {
            Map<String, Integer> midMap = new HashMap<>();
            for (int j = 0; j < value.size(); j++) {
                if (visited[j] != null)continue;
                String k = value.get(j);
                midMap.put(k.substring(0, i + 1), midMap.getOrDefault(k.substring(0, i + 1) ,0) + 1);
            }
            for (int j = 0; j < visited.length; j++) {
                if (visited[j] == null && midMap.get(value.get(j).substring(0, i + 1)) == 1) {
                    visited[j] = getString(i, value.get(j));
                }
            }
        }
        for (String K : visited) {
            res.add(K);
        }
    }

    private String getString(int i, String k) {
        String tmp = k.substring(0, i + 1) + suffixAbbr(k.substring(i + 1));
        return tmp;
    }

    private String suffixAbbr(String substring) {
        if (substring.length() <= 2) {
            return substring;
        }
        String res = substring.length() -1 + "" + substring.charAt(substring.length()- 1);
        return res;
    }

    private String abbr(String s) {
        if (s.length() <= 3) {
            return s;
        }
        return s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
    }

}
