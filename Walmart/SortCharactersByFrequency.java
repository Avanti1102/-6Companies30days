class Day15 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb =new StringBuilder("");

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(char ch : map.keySet()){
           pq.add(ch);
        }
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }       
        return sb.toString();
    }
}