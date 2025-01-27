class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        long n = arr.length;
        long sumOfN = (n * (n+1))/2;
        long sumofSqOfN = (n * (n+1) * (2*n+1))/6;
        
        
        long sumObt = 0;
        long sqSumObt = 0;
        for(long num : arr){
            sumObt += num;
            sqSumObt += (num*num);
        }
        
        long val1 = sumOfN - sumObt;
        long val2 = sumofSqOfN - sqSumObt ;
        val2 = val2/val1;
        
        int missing = (int)(val1+val2)/2;
        int repeating  = (int)(val2- missing);
        ans.add(repeating);
        ans.add(missing);

        return ans;      
        
    }
}