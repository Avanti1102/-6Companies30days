class KthLargest {
    int k;
    List<Integer> stream;
    public KthLargest(int k, int[] nums) {
        stream =new ArrayList<Integer>(nums.length);
        this.k=k;
        for(int num : nums){
            stream.add(num);
            
        }
        Collections.sort(stream);
    }
    
    public int add(int val) {
        int idx=getIndex(val);
        stream.add(idx, val);
        return stream.get(stream.size()-k);
    }

    private int getIndex(int val){
        int s=0;
        int e=stream.size()-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(stream.get(mid)==val){
                return mid;
            }
            if(stream.get(mid)>val){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return s;
    }
}
