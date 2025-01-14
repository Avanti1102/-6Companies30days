class Day15 {
    public int maxRotateFunction(int[] nums) {
        
      int sum=0;
      int Fn = 0;
      int n=nums.length;

      for(int i=0;i<n;i++){
        sum += nums[i];
        Fn += i*nums[i];

      }  

      int max = Fn;
      for (int k = 1; k < n; k++) {
        Fn = Fn + sum - n * nums[n - k];
        max = Math.max(max, Fn);
      }
      return max;
    }
}