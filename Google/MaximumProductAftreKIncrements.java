class Day21 {
    public int maximumProduct(int[] nums, int k) {
         
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)    pq.add(num);
        
        while (k>0) {
            int top = pq.poll() + 1 ;
            pq.add(top);
            k--;
        }

        long res = 1;
        while (!pq.isEmpty()) {
            res = (res*pq.poll()) % 1000000007;
        }

        return (int)(res);
    }
}