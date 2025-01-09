class Day10 {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
       
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  //decreasing priority
        
        Map<Integer, Integer> fMap = new HashMap<>();
        
        int start=0;
        int end=0;
        
        while (end < k) {
            pq.add(arr[end]);
            fMap.put(arr[end], fMap.getOrDefault(arr[end], 0) + 1);
            end++;
        }
        
        ans.add(pq.peek());
         
        while (end < arr.length) {
            // Add new element
            pq.add(arr[end]);
            fMap.put(arr[end], fMap.getOrDefault(arr[end], 0) + 1);
            
            // Remove start element from frequency map
            fMap.put(arr[start], fMap.get(arr[start]) - 1);
            
            // Remove elements from priority queue that are no longer in the window
            while (!pq.isEmpty() && fMap.get(pq.peek()) == 0) {
                pq.poll();
            }
            
            // Add max of current window
            ans.add(pq.peek());
            
            // Move window
            start++;
            end++;
        }
        return ans;
    }
}