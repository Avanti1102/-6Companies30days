class Day3 {
    public int numberOfSubarrays(int[] nums, int k) {
       int n= nums.length;
        int [] count = new int [n+1]; 
            count[0]=1;
            int res=0,oddcount=0;
            for(int num:nums){
                if(num%2!=0) oddcount++;
                if(oddcount - k >= 0){
                    res+= count[oddcount - k];
                }
                count[oddcount]++;
            }
        return res;
    }
}