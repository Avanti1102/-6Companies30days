class Day3 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length-1)/2;
        int right = nums.length-1;
        int[] arr = new int[nums.length];
       
        int counter=0;
        while(mid >= 0 || right > (nums.length - 1 ) / 2 ){
            
            if(counter % 2 == 0){
                arr[counter] = nums[mid];
                mid--;
            } else {
               arr[counter] = nums[right];
                right--;
            }
            
            counter++;
        }

        for(int i=0;i<nums.length;i++)  {
            nums[i]= arr[i];
        }
         
    }
}