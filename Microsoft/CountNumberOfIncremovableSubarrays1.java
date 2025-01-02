class Day3 {
    public int incremovableSubarrayCount(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++){
            for(int j=i; j<nums.length;j++){
               if(helper(nums, i, j)){
                ans++;
               }
            }
        }
        return ans;
        
    }
    public boolean helper( int arr[], int s, int e){
        int prev=0;
        for(int i=0;i<arr.length;i++){
            if(i >= s && i <= e){
                continue;
            }
            if(arr[i]<=prev){
                return false;
            }
            prev=arr[i];
        }
        return true;
    }
}