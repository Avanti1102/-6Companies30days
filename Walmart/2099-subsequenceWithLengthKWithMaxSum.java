class Day14 {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();   //asecending order
        List<Integer> list=new ArrayList<>(); 
        for(int x:nums){
            pq.add(x);
            list.add(x);
        }
        
        int[] ans=new int[k];
        
        for(int i=0;i<nums.length-k;i++){
            list.remove(pq.remove());
        }
            
        
        for(int i=0;i<k;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}