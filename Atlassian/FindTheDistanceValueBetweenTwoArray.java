class Day24 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int i=0;i<arr1.length;i++){
            if(isValid(arr1[i], arr2, d)){
                count++;
            }
        }
        return count;
    }
    private boolean isValid(int ele, int arr2[], int d){
        int s=0;
        int e=arr2.length-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            int diff =Math.abs(arr2[mid] - ele);
            if(diff <= d){
                return false;
            }else if(arr2[mid] > ele){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return true;
    }
}