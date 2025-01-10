class Day11 {
    public int waysToReachStair(int k) {
         Map<String, Integer> map = new HashMap<>();
        return dfs(1, 0, k, false, map);
    }
    private int dfs(int cur, int jump, int k, boolean isBacked, Map<String, Integer> map) {

        //Termination 
        if (cur < 0 || (cur > k + 1))
            return 0;

        //Memo
        String memo = cur + ":" + jump + ":" + isBacked;
        if (map.containsKey(memo))
            return map.get(memo);

        // cur == k Means I am at required final stair [we should not terminte] just need to add one possible solution, bcz there is change to reach it again. If we observe from give test cases explanation.
        int res = cur == k ? 1 : 0;

        // check for isBacked means took one step back in previous call, bcz consecutive in not allowed.
        if (cur > 0 && !isBacked) {
            res += dfs(cur - 1, jump, k, true, map);
        }

        //jump i+2^jump
        res += dfs(cur + (1 << jump), jump + 1, k, false, map);

        map.put(memo, res);
        return res;
    }

}