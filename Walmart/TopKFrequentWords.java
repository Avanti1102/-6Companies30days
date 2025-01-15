class Day16 {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : words ){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        ArrayList<String> ans = new ArrayList<>(map.keySet());

        Collections.sort(ans, (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));

        
        return ans.subList(0, k);
    }
}