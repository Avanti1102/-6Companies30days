class Day3 {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int len = s.length();
        int left=0;
        int right=10;
        while(left <= len-10){
            
            String curr = s.substring(left, right);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            left++; right++;
        }
        for(String str : map.keySet()){
            if(map.get(str) > 1){
                ans.add(str);
            }
        }
        return ans;
    }
}