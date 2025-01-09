class Day10 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(k>n){
            return 0;
        }
        long sum =0;
        long maxSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
		
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            sum += nums[i];
			
            if(i>=k){
                map.put(nums[i-k],map.get(nums[i-k]) - 1);
                sum -= nums[i-k];
                
                if(map.get(nums[i-k]) == 0)
                    map.remove(nums[i-k]);
            }
			
            if(map.size() == k)
                maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}