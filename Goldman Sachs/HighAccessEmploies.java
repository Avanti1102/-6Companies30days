class Day30 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(List<String> list : access_times){
            String emp = list.get(0) ;
            int time = Integer.valueOf(list.get(1));
            //add emp into map and time in time list for that emp
            map.computeIfAbsent(emp, v-> new ArrayList<>()).add(time);
        }
        List<String> ans = new ArrayList<>();
        for(String emp : map.keySet()){
            List<Integer> t = map.get(emp);  //time list for that emp
            Collections.sort(t);
            int n = t.size();
            for(int i=0;i<n-2;i++){
                if(t.get(i)+100 > t.get(i+1) && t.get(i)+100 > t.get(i+2)){  //check for three 
                    ans.add(emp);
                    break;
                }
            }

        }
        return ans;
    }
}