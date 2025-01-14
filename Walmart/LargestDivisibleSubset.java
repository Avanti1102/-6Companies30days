class Day13 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n =nums.length;
        if(n==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int []dp = new int[n];
        int []prevIdx = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIdx, -1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    prevIdx[i] = j;
                }

            }
        }
        
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prevIdx[maxIndex];
        }

        return result;
    }
}